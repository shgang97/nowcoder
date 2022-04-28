package com.nowcoder.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: shg
 * @create: 2022-04-28 7:29 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ThreadPoolTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolTests.class);

    // JDK 自带的普通线程池
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    // JDK自带的可执行定时任务的线程池
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // spring普通线程池
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 1. JDK普通线程池
    @Test
    public void testExecutorService() {
        Runnable task = () -> {
            LOGGER.info("hello, ExecutorService");
        };

        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
        sleep(10 * 1000);
    }

    @Test
    public void testScheduledService() {
        Runnable task = () -> {
            LOGGER.info("hello, ScheduledService");
        };

        for (int i = 0; i < 10; i++) {
            scheduledExecutorService.scheduleAtFixedRate(task, 10000, 1000, TimeUnit.MILLISECONDS);
        }
        sleep(10 * 1000);
    }

    @Test
    public void testSpringExecutor() {
        Runnable task = () -> {
            LOGGER.info("hello, SpringExecutor");
        };

        for (int i = 0; i < 100; i++) {
            taskExecutor.submit(task);
        }
        sleep(10 * 1000);
    }

    @Test
    public void testSpringScheduler() {
        Runnable task = () -> {
            LOGGER.info("hello, SpringExecutor");
        };

        Date startTime = new Date(System.currentTimeMillis() + 10000);
        for (int i = 0; i < 100; i++) {
            taskScheduler.scheduleAtFixedRate(task, startTime, 1000);
        }
        sleep(10 * 1000);
    }
}
