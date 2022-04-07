package com.nowcoder.community.dao;

import com.nowcoder.community.CommunityApplication;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: shg
 * @create: 2022-04-07 3:24 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        User user = userMapper.selectById(101);
        System.out.println("user = " + user);
    }

    @Test
    public void selectByName() {
        User user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println("user = " + user);
    }

    @Test
    public void selectByEmail() {
    }

    @Test
    public void insertUser() {
    }

    @Test
    public void updateStatus() {
    }

    @Test
    public void updateHeader() {
    }

    @Test
    public void updatePassword() {
    }
}