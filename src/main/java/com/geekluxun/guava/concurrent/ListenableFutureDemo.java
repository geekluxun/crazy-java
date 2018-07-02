package com.geekluxun.guava.concurrent;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: luxun
 * @Create: 2018-06-30 20:24
 * @Description:
 * @Other:
 */
public class ListenableFutureDemo {

    public static void main(String[] argc) {
        ListenableFutureDemo demo = new ListenableFutureDemo();
        demo.testListenableFuture();
    }

    public void testListenableFuture() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Task("testListenableFuture"));

        //同步获取调用结果
        try {
            System.out.println(listenableFuture.get());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }

        //第一种方式
        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("get listenable future's result " + listenableFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, executorService);

        //第二种方式
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    class Task implements Callable<Integer> {
        String str;

        public Task(String str) {
            this.str = str;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("call execute.." + str);
            TimeUnit.SECONDS.sleep(1);
            return 7;
        }
    }
}
