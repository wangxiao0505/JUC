package com.wangxiao.juc.c_013;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxiao
 * @desc volatile并不能保证多个线程共同修改running变量是所带来的不一致问题，也就是说volatile不能代替synchronized
 * 运行下面程序，并分析结果
 * @date 2020-12-21 15:31:00
 */
public class T {
    volatile int count = 0;
    void m(){
        for(int i=0;i<10000;i++) {
        count++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.add(new Thread(t::m,"t1"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
