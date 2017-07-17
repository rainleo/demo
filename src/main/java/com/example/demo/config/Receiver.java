package com.example.demo.config;


import com.example.demo.domain.UserDO;
import com.example.demo.util.RedisObjectSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by niewenlong on 2017/5/25.
 */
public class Receiver implements MessageListener{

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        RedisObjectSerializer redisObjectSerializer = new RedisObjectSerializer();
        UserDO userDO = (UserDO)(redisObjectSerializer.deserialize(message.getBody()));
        System.out.println(message + "==="+userDO.getName());
    }

    /*public void receiveMessage(Message message) {
        RedisObjectSerializer redisObjectSerializer = new RedisObjectSerializer();
        LOGGER.info("Received <" + redisObjectSerializer.deserialize(message.getBody()) + ">");
        latch.countDown();
    }*/

}
