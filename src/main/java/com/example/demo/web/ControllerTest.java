package com.example.demo.web;

import com.example.demo.config.testConfig.AsyncTaskTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Created by niewenlong on 2017/7/25.
 */
@RestController
public class ControllerTest {

    @Autowired
    private AsyncTaskTest asyncTaskTest;
    /**
     * 异步回调demo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testAsyncTask", method = RequestMethod.GET)
    public long testAsyncTask() throws Exception {
        long startTime = System.currentTimeMillis();
        Future<String> task1 = asyncTaskTest.doTaskOne();
        Future<String> task2 = asyncTaskTest.doTaskTwo();
        Future<String> task3 = asyncTaskTest.doTaskThree();
        while(true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
}
