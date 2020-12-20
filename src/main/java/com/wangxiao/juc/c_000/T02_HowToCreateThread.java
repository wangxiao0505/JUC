package com.wangxiao.juc.c_000;

/**
 * @author wangxiao
 * @desc  启动线程的三种方式： 1:Thread 2:Runnable 3:Executors.newCachedThread
 * @date 2020-12-16 20:08:34
 */
public class T02_HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("myThread");
        }
    }
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("myRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("lambda");
        }).start();
    }
}
