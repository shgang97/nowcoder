package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CommunityApplication {

	@PostConstruct
	public void init() {
		// 解决netty启动冲突问题
		// Netty4Utils.class
		System.setProperty("es.set.netty.runtime.available.processors", "true");
	}

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
