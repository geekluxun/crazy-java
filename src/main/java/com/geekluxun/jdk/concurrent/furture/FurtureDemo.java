package com.geekluxun.jdk.concurrent.furture;

import java.util.concurrent.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-22 10:09
 * @Description:
 * @Other:
 */
public class FurtureDemo {
    public static void main(String[] argc){
        FurtureDemo demo = new FurtureDemo();
        demo.demo1();
        
    }

    /**
     * 如何interrupt一个任务??
     */
    private void demo1(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        
        Future<String> future = executorService.submit(()->{
            System.out.println("hello");
            //int value = 0 / 0;
            while (true){
                TimeUnit.SECONDS.sleep(1);
            }
            //return "hello world";
        });
        
        try {
            String result = future.get();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            // 在task里抛出异常会转换成执行异常
            e.printStackTrace();
        }
    }
}
