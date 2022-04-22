package com.nowcoder.community.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author: shg
 * @create: 2022-04-22 7:06 下午
 */
@Data
@ToString
public class Message{
    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int status;
    private Date createTime;
}
