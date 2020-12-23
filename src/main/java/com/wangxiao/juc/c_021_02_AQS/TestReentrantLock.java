package com.wangxiao.juc.c_021_02_AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangxiao
 * @desc ...
 * @date 2020-12-23 10:50:55
 */
public class TestReentrantLock {
    private volatile static int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            //synchronized (TestReentrantLock.class){
                i++;
            //}
        }finally {
            lock.unlock();
        }
    }
}
