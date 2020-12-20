package com.wangxiao.juc.c_003;

/**
 * @author wangxiao
 * @desc synchronized关键字  对某个对象加锁
 * @date 2020-12-18 10:25:33
 */
public class T {
    private int count = 10;
    public synchronized void  m(){// 等同于在方方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }
}
