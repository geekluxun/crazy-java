package com.geekluxun.design.patterns.observer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 13:36
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver();

        subject.registerObserver(observer);

        subject.setTemp(1.55f);
        subject.notifyObservers();
    }
}
