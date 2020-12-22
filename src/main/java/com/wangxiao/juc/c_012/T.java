package com.wangxiao.juc.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @author wangxiao
 * @desc ...
 * @date 2020-12-20 11:25:50
 */
public class T {
    /*volatile*/ boolean running = true;
    void m(){
        System.out.println("m start");
        while(running){
           /* try {
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T t = new T();

        new Thread(t::m,"t1").start();

        //lambda new Thread(new Runnable(run(){m()}))

        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
