package com.wangxiao.juc.c_004;

/**
 * @author wangxiao
 * @desc ...
 * @date 2020-12-18 10:34:18
 */
public class T {
    private static int count = 10;
    public synchronized static void m(){//这里等同于synchroinzed(T.class)
        count--;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }

    public static void mm(){
        synchronized(T.class){// 考虑一下这里写synchronized(this)是否可以？
            count--;
        }
    }
}
