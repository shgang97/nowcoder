package com.nowcoder.community.entity;

/**
 * @author: shg
 * @create: 2022-04-08 12:18 上午
 */

import lombok.Data;
import lombok.ToString;

/**
 * 封装分页相关的信息
 */
@Data
@ToString
public class Page {
    // 当前页码
    private int current = 1;
    // 显示上限
    private int limit = 10;
    // 封装总数（用于计算总页数）
    private int rows;
    // 查询路径（用于复用分页链接）
    private String path;

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public void setLimit(int limit) {
        if (1 <= limit && limit <= 100) {
            this.limit = limit;
        }
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        }
        return rows / limit + 1;
    }

    /**
     *
     * @return
     */
    public int getFrom() {
        int from = (getTotal() - current) < 2 ? (getTotal() - 5) : current - 2;
        return Math.max(from, 1);
    }

    /**
     * 获取结束页码
     * @return
     */
    public int getTo() {
        int to = current < 3 ? 5 : current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }
}
