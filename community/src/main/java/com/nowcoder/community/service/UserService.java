package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: shg
 * @create: 2022-04-07 10:44 下午
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public User findUserById(int id) {
        return mapper.selectById(id);
    }
}
