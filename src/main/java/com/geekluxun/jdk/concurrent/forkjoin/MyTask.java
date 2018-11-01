package com.geekluxun.jdk.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-22 9:54
 * @Description:
 * @Other:
 */
public class MyTask extends RecursiveTask<Integer> {
    Integer n;

    public MyTask(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        System.out.println("计算线程id:" + Thread.currentThread().getId());
        if (n <= 1) {
            return n;
        }
        int value = 0 / 0;
        MyTask myTask = new MyTask(n - 1);
        // 分割任务
        myTask.fork();

        // 汇总子任务的计算结果
        return n * n + myTask.join();
    }
}
