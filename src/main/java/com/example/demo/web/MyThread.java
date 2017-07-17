package com.example.demo.web;


/**
 * Created by niewenlong-work on 2017/6/5.
 */
public class MyThread implements Runnable {

    private volatile  int ticket = 40;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票,x=" + this.ticket-- + "i>>>" + i);
                }
            }
        }
    }
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"票贩子A").start();
        new Thread(mt,"票贩子B").start();
        new Thread(mt,"票贩子C").start();
    }
}

