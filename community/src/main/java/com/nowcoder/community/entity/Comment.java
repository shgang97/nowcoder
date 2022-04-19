package com.nowcoder.community.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author: shg
 * @create: 2022-04-18 8:44 下午
 */
@Data
@ToString
public class Comment {
    private int id;
    private int userId;
    private int entityType;
    private int entityId;
    private int targetId;
    private String content;
    private Date createTime;
}
