package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: shg
 * @create: 2022-04-07 10:25 下午
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper mapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return mapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return mapper.selectDiscussPostRows(userId);
    }
}
