package com.example.demo.config.testConfig;

/**
 * Created by niewenlong on 2017/8/4.
 */
public class Test {

    public static void main(String[] args) {
        String a = "103,1,2,";
        String dutyIds =a.replace(103+",","");
        System.out.println(dutyIds);
    }
}
