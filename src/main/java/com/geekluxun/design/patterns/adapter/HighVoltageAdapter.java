package com.geekluxun.design.patterns.adapter;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:17
 * @Description:
 * @Other:
 */
public class HighVoltageAdapter implements HighVoltage{
    /**
     * 客户端代码不能直接使用LowVoltage提供的接口，只能使用HighVoltage提供
     * 的接口，所以适配器把HighVoltage适配成LowVoltage
     */
    private LowVoltage lowVoltage;

    public HighVoltageAdapter(){
        lowVoltage = new LowVoltage110V();
    }

    @Override
    public void useHighVoltage() {
        lowVoltage.useLowVoltage();
    }
}
