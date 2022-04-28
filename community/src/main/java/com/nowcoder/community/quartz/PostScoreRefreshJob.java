package com.nowcoder.community.quartz;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.ElasticSearchService;
import com.nowcoder.community.service.LikeService;
import com.nowcoder.community.util.CommunityConstant;
import com.nowcoder.community.util.RedisKeyUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: shg
 * @create: 2022-04-28 10:27 下午
 */
public class PostScoreRefreshJob implements Job, CommunityConstant {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostScoreRefreshJob.class);

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Date epoch;

    static {
        try {
            epoch = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-06 00:00:00");
        } catch (ParseException e) {
            throw new RuntimeException("初始化社区纪元失败", e);
        }
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String redisKey = RedisKeyUtil.getPostScoreKey();
        BoundSetOperations operations = redisTemplate.boundSetOps(redisKey);
        if (operations.size() == 0) {
            LOGGER.info("[任务取消]没有需要刷新的帖子");
        }
        LOGGER.info("[任务开始]正在刷新帖子分数：" + operations.size());
        while (operations.size() > 0) {
            this.refresh((Integer) operations.pop());
        }
        LOGGER.info("[任务结束]帖子分数刷新完毕");
    }

    private void refresh(Integer postId) {
        DiscussPost post = discussPostService.findDiscussPostById(postId);
        if (post == null) {
            LOGGER.info("该帖子不存在：id = %s", postId);
        }
        // 计算公式
        // log(精华分 + 评论数*10 + 点赞数*2 + 收藏数*2) + (发布时间 - 社区纪元)
        // 是否加精
        boolean wonderful = post.getStatus() == 1;
        // 评论数量
        int commentCount = post.getCommentCount();
        // 点赞数量
        long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, postId);
        // 计算权重
        double w = (wonderful ? 75 : 0) + commentCount * 10 + likeCount * 2;
        double score = Math.log10(Math.max(w, 1)) + ((post.getCreateTime().getTime() - epoch.getTime()) / (1000 * 24 * 3600));
        // 更新帖子分数
        discussPostService.updateScore(postId, score);
        post.setScore(score);
        elasticSearchService.saveDiscussPost(post);
    }
}
