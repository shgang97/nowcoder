package com.nowcoder.community.dao.elasticsearch;

import com.nowcoder.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: shg
 * @create: 2022-04-26 10:03 下午
 */
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {
}
