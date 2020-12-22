package com.wangxiao.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangxiao
 * @desc reentrantlock用于替代synchronized
 *  由于m锁定this，只有m1执行完毕的时候，m2才能执行
 *  这里是复习synchronized最原始的语义
 *
 *  使用reentrantlock可以完成同样的功能
 *  需要注意的是，必须要必须要必须要手动释放锁（重要的事说三遍）
 *  使用sync锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * @date 2020-12-21 20:36:37
 */
public class T02_ReentrantLock2 {
    Lock lock = new ReentrantLock();
    void m1(){
        lock.lock(); //synchronized(this)
        try {
            for(int i=0;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        try{
            System.out.println("m2--");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        T02_ReentrantLock2 t = new T02_ReentrantLock2();
        new Thread(t::m1,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m2).start();
    }
}
