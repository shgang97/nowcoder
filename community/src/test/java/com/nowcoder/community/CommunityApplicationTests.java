package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	@Autowired
	@Qualifier("hibernate")
	private AlphaDao alphaDao;

	@Test
	public void testDI() {
		System.out.println("alphaDao = " + alphaDao);
	}

	private ApplicationContext context;

	@Test
	public void testBeanConfig() {
		SimpleDateFormat simpleDateFormat = context.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	@Test
	public void testBeanManagement() {
		AlphaService service = context.getBean(AlphaService.class);
		System.out.println("service = " + service);
	}

	@Test
	void contextLoads() {
		System.out.println(context);

		AlphaDao alphaDao = context.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		AlphaDao alphaDao1 = context.getBean("hibernate", AlphaDao.class);
		System.out.println("alphaDao1 = " + alphaDao1.select());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
