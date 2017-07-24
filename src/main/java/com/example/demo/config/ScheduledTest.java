package com.example.demo.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by niewenlong on 2017/7/24.
 */
@Component
public class ScheduledTest {

    @Scheduled(fixedRate = 1000)
    public void sysNowTimeEverySecond(){
        System.out.println(System.currentTimeMillis());
    }
}
