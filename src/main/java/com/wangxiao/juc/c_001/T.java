package com.wangxiao.juc.c_001;

/**
 * @author wangxiao
 * @desc synchronized关键字   对某个字段加锁
 * @date 2020-12-18 09:50:49
 */
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m(){
        synchronized (o){// 任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }
    }

}
