package com.nowcoder.community.dao;

import com.nowcoder.community.CommunityApplication;
import com.nowcoder.community.entity.LoginTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: shg
 * @create: 2022-04-09 11:02 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoginTicketMapperTest {

    @Autowired
    private LoginTicketMapper mapper;

    @Test
    public void insertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        mapper.insertLoginTicket(loginTicket);

    }

    @Test
    public void selectByTicket() {
        LoginTicket loginTicket = mapper.selectByTicket("abc");
        System.out.println("loginTicket = " + loginTicket);
    }

    @Test
    public void updateStatus() {
        int i = mapper.updateStatus("abc", 1);
        System.out.println(i);
    }
}