package com.wangxiao.juc.c_005;

/**
 * @author wangxiao
 * @desc 分析一下这个程序的输出
 * @date 2020-12-18 10:40:44
 */
public class T implements Runnable {
    private /*volatile*/ int count = 100;
    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"  count="+count);
    }

    public static void main(String[] args) {
        T t = new T();
        for(int i=0;i<100;i++){
            new Thread(t,"THREAD"+i).start();
        }
    }
}
