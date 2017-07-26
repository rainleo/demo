package com.example.demo.config.testConfig;

/**
 * Created by niewenlong on 2017/7/24.
 */

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步回调demo
 */
@Component
public class AsyncTaskTest {

    @Async
    public Future<String> doTaskOne() throws Exception{
        System.out.println("doTaskOne:开始》》"+System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("doTaskOne:结束》》"+System.currentTimeMillis());
        return new AsyncResult<>("任务一完成");
    }
    @Async
    public Future<String> doTaskTwo() throws Exception{
        System.out.println("doTaskTwo:开始》》"+System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("doTaskTwo:结束》》"+System.currentTimeMillis());
        return new AsyncResult<>("任务二完成");
    }
    @Async
    public Future<String> doTaskThree() throws Exception{
        System.out.println("doTaskThree:开始》》"+System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("doTaskThree:结束》》"+System.currentTimeMillis());
        return new AsyncResult<>("任务三完成");
    }
}
