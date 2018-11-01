package com.geekluxun.guava.concurrency;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-02 9:05
 * @Description:
 * @Other: 使用场景 The most important reason to use ListenableFuture is that
 * it becomes possible to have complex chains of asynchronous operations.
 */
public class ListenableFutureDemo {
    public static void main(String[] argc) {
        ListenableFutureDemo demo = new ListenableFutureDemo();
        demo.demo1();
    }


    private void demo1() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call....");
                TimeUnit.SECONDS.sleep(5);
                return 10;
            }
        });

        // 方式一 增加一个监听器，会在futrue执行结束后调用
        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("计算结果：" + listenableFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, executorService);

        // 方式二 通过回调
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer integer) {
                System.out.println("调用成功:" + integer);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("调用失败:" + throwable);
            }
        }, executorService);

    }


}
