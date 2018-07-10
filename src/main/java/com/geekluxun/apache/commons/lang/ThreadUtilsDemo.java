package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.ThreadUtils;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 11:33
 * @Description:
 * @Other:
 */
public class ThreadUtilsDemo {
    public static void main(String[] argc){
        ThreadUtilsDemo demo = new ThreadUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        threadDemo();
        Thread thread = ThreadUtils.findThreadById(1);
        Collection<Thread> threadList = ThreadUtils.findThreadsByName("Thread-0");
        threadList = ThreadUtils.getAllThreads();
        
        Collection<ThreadGroup> threadGroups = ThreadUtils.getAllThreadGroups();
        // 获取root 线程组
        ThreadGroup threadGroup = ThreadUtils.getSystemThreadGroup();
        // 根据线程名创建谓词
        ThreadUtils.NamePredicate namePredicate = new ThreadUtils.NamePredicate("main");
        // 表示is的关系
        boolean result = namePredicate.test(Thread.currentThread());
        
        // 线程id谓词 表示"是"
        ThreadUtils.ThreadIdPredicate threadIdPredicate = new ThreadUtils.ThreadIdPredicate(1);
        result = threadIdPredicate.test(Thread.currentThread());
        System.out.println();
    }
    
    private void threadDemo(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("id:" + Thread.currentThread().getId());
                System.out.println("name:" + Thread.currentThread().getName());
                ThreadGroup group = Thread.currentThread().getThreadGroup();
            
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
