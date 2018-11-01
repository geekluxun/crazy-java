package com.geekluxun.jdk.concurrent.threadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-22 14:14
 * @Description:
 * @Other:
 */
public class ThreadLocalDemo implements Runnable {
    //private static ThreadLocal<Integer> value = new ThreadLocal<>();
    private Integer value;

    public static void main(String[] argc) {
        for (int i = 0; i < 100; i++) {
            new Thread(new ThreadLocalDemo()).start();
        }
    }


    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random(100).nextInt());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = (int) (Thread.currentThread().getId());
        System.out.println("value:" + value);
//        value.set(Integer.valueOf((int)Thread.currentThread().getId()));
//        System.out.println("value:" + value.get());
    }
}
