package com.wangxiao.juc.c_017;

import java.util.concurrent.TimeUnit;

/**
 * @author wangxiao
 * @desc 锁定某对象o，如果o的属性发生改变，不影响锁的使用
 *  但是如果o变成另一个对象，则锁定的对象发生改变
 *  应避免将锁定的引用变成另外的对象
 * @date 2020-12-21 16:01:55
 */
public class T {
    // 将对象修饰成final，从而禁止重新创建对象
    /*final*/ Object o = new Object();
    void m(){
        synchronized (o){
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        // 启动第一个线程
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //创建第二个线程
        Thread t2 = new Thread(t::m,"t2");

        t.o = new Object(); // 锁对象发生改变，所以t2线程得以执行，如果注释掉这句话，线程2将永远得不到执行机会
        t2.start();
    }
}
