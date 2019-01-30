package com.geekluxun.design.patterns.strategy;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:46
 * @Description:
 * @Other:
 */
public class PlainTravel implements Travel {
    @Override
    public void travel() {
        System.out.println("乘坐飞机出行...");
    }
}
