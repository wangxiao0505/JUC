package com.wangxiao.juc.c_012;

/**
 * @author wangxiao
 * @desc ...
 * @date 2020-12-21 15:21:21
 */
public class TestVolatile {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends  Thread{
        @Override
        public void run() {
            while(!ready){
                /*Thread.yield();*/
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        new Thread(()->{
            number = 42;
            while(true){}
        }).start();

        /*number = 42;
        ready = true;*/
    }
}
