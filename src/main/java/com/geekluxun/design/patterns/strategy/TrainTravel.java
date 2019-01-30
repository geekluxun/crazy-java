package com.geekluxun.design.patterns.strategy;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:43
 * @Description:
 * @Other:
 */
public class TrainTravel implements Travel {
    @Override
    public void travel() {
        System.out.println("乘坐火车出行...");
    }
}
