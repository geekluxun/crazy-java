package com.geekluxun.design.patterns.observer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 13:27
 * @Description:
 * @Other:
 */
public class ConcreteObserver implements Observer {


    @Override
    public void update(float temp) {
        System.out.println("收到通知，当前温度:" + temp);
    }
}
