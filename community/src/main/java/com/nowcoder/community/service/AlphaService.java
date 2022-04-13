package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: shg
 * @create: 2022-04-06 11:58 下午
 */
@Service
//@Scope("prototype")
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String find() {
        return alphaDao.select();
    }

//    public AlphaService() {
//        System.out.println("AlphaService.AlphaService");
//    }

//    @PostConstruct
//    public void init() {
//        System.out.println("AlphaService.init");
//    }
//
//    @PreDestroy
//    public void destroy() {
//        System.out.println("AlphaService.destroy");
//    }
}
