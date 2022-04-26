package com.nowcoder.community.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shg
 * @create: 2022-04-25 10:08 下午
 */
@Data
@ToString
@Accessors(chain = true)
public class Event {
    private String topic;
    private int userId;
    private int entityType;
    private int entityId;
    private int entityUserId;
    private Map<String, Object> data = new HashMap<>();

    public Event setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
