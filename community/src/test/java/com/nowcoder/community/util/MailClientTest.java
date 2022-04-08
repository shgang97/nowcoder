package com.nowcoder.community.util;

import com.nowcoder.community.CommunityApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.Assert.*;

/**
 * @author: shg
 * @create: 2022-04-08 4:23 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailClientTest {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendMail() {
        mailClient.sendMail("853762531@qq.com", "test", "hello, qq email");
    }

    @Test
    public void sendThymeleafMail() {
        Context context = new Context();
        context.setVariable("username", "sandy");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(context);
        mailClient.sendMail("853762531@qq.com", "HTML", content);
    }
}