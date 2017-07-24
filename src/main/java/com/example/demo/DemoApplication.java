package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling//启动定时任务的配置
@EnableAsync//异步回调
public class DemoApplication {


	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
	}
}
