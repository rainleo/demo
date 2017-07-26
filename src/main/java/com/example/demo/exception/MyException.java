package com.example.demo.exception;

/**
 * Created by niewenlong-work on 2017/5/23.
 */
//定义统一的异常处理类
public class MyException extends Exception {

    public MyException(String message){
        super(message);
    }
}
