package com.wangxiao.juc.c_020;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangxiao
 * @desc 使用读写锁效率明显提高
 * @date 2020-12-22 10:37:29
 */
public class T10_TestReadWriteLock {
    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("read over---");
            //模拟读操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock,int v){
        lock.lock();
        try {
            Thread.sleep(1000);
            value = v;
            System.out.println("write over---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //Runnable r = ()-> read(lock);
        Runnable r = ()-> read(readLock);

        //Runnable w = ()-> write(lock,new Random().nextInt());
        Runnable w = ()-> write(writeLock,new Random().nextInt());

        for(int i=0;i<18;i++){
            new Thread(r).start();
        }
        for(int i=0;i<2;i++){
            new Thread(w).start();
        }

    }
}
