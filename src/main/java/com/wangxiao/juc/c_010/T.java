package com.wangxiao.juc.c_010;

import java.util.concurrent.TimeUnit;

/**
 * @author wangxiao
 * @desc ...
 * @date 2020-12-18 15:38:53
 */
public class T {

    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T{
    @Override
    synchronized void m() {
        System.out.println("child start");
        super.m();
        System.out.println("child end");
    }
}