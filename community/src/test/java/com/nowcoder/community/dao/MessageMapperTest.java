package com.nowcoder.community.dao;

import com.nowcoder.community.CommunityApplication;
import com.nowcoder.community.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: shg
 * @create: 2022-04-22 7:44 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MessageMapperTest {

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void selectConversations() {
        List<Message> messages = messageMapper.selectConversations(111, 0, 20);
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    @Test
    public void selectConversationCount() {
        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);
    }

    @Test
    public void selectLetters() {
        List<Message> messages = messageMapper.selectLetters("111_112", 0, 20);
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    @Test
    public void selectLetterCount() {
        System.out.println(messageMapper.selectLetterCount("111_112"));
    }

    @Test
    public void selectLetterUnreadCount() {
        int count = messageMapper.selectLetterUnreadCount(131, "111_131");
        System.out.println(count);
    }
}