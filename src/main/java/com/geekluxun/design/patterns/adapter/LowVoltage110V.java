package com.geekluxun.design.patterns.adapter;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:24
 * @Description:
 * @Other:
 */
public class LowVoltage110V implements LowVoltage {
    @Override
    public void useLowVoltage() {
        System.out.println("在使用110V低压");
    }
}
