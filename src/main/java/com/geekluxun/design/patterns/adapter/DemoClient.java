package com.geekluxun.design.patterns.adapter;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:28
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc){
        HighVoltage highVoltage =new  HighVoltageAdapter();
        highVoltage.useHighVoltage();
    }
}
