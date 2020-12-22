package com.wangxiao.juc.c_018_01_Unsafe;

import sun.misc.Unsafe;

/**
 * @author wangxiao
 * @desc ...
 * @date 2020-12-21 21:43:02
 */
public class HelloUnsafe {
    static class M {
        private M() {}

        int i =0;
    }
    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}
