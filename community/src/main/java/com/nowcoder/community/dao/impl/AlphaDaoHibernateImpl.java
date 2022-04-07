package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * @author: shg
 * @create: 2022-04-06 11:49 下午
 */
@Repository("hibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
