package com.geekluxun.design.patterns.observer;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 12:31
 * @Description:  
 * @Other:
 */
public interface Observer {
    /**
     * 观察者提供给主题Subject的回调， 
     * Subject会在数据（温度）变化的时候通过此接口回调通知观察者
     * @param temp
     */
    void update(float temp);
}
