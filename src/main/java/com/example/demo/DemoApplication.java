package com.example.demo;

import com.example.demo.config.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		//<editor-fold desc="redis发布消息">
		/*RedisTemplate<String,UserDO> template = (RedisTemplate<String,UserDO>)ctx.getBean("redisTemplate");
		CountDownLatch latch = ctx.getBean(CountDownLatch.class);
		LOGGER.info("Sending message...");
		UserDO userDO = new UserDO();
		userDO.setId(1L);
		userDO.setAge(1);
		userDO.setName("niewenlong");
		template.convertAndSend("chat1", userDO);
		latch.await();
		System.exit(0);*/
		//</editor-fold>
	}
}
