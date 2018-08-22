package com.geekluxun.jdk.concurrent.forkjoin;

import org.springframework.util.Assert;

import java.util.concurrent.ForkJoinPool;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-22 9:58
 * @Description:
 * @Other:
 */
public class ForkJoinDemo {
    public static void main(String[] argc){

        System.out.println("main线程id:" + Thread.currentThread().getId());

        ForkJoinPool forkJoinPool = null;
        try {
            forkJoinPool = new ForkJoinPool();
            MyTask myTask = new MyTask(4);
            forkJoinPool.execute(myTask);
            //4*4  + 3*3 + 2*2 + 1*1;
            int result  = myTask.join().intValue();
            Assert.isTrue(myTask.join().intValue() == 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
