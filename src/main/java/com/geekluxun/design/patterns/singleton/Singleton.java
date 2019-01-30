package com.geekluxun.design.patterns.singleton;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 16:51
 * @Description:
 * @Other:
 */
public class Singleton {
    private volatile static Singleton uniqueSingleton ;

    /**
     * 双重加锁实现线程安全的单例
     * @return
     */
    public static Singleton createInstance(){
        if (uniqueSingleton == null){
            synchronized (Singleton.class){
                if (uniqueSingleton == null){
                    uniqueSingleton = new Singleton();
                }
            }
        }
        return uniqueSingleton;
    }
}
