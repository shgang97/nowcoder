package com.nowcoder.community.service;

import com.nowcoder.community.CommunityApplication;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author: shg
 * @create: 2022-04-08 9:36 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void register() {
        User user = new User();
        user.setUsername("shgang");
        user.setPassword("123445");
        user.setEmail("shgang97@163.com");
        Map<String, Object> map = userService.register(user);
        map.forEach((k, v) -> {
            System.out.println("k = " + k + ", v = " + v);
        });

    }

}