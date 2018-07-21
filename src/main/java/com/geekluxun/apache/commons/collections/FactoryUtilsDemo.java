package com.geekluxun.apache.commons.collections;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FactoryUtils;

import java.math.BigDecimal;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 13:55
 * @Description:
 * @Other:
 */
public class FactoryUtilsDemo {
    public static void main(String[] argc){
        FactoryUtilsDemo demo = new FactoryUtilsDemo();
        demo.demo1();
        demo.demo2();
    }
    
    private void demo1(){
        Factory<BigDecimal> factory = FactoryUtils.constantFactory(new BigDecimal("10.0"));
        BigDecimal value = factory.create();
        value = factory.create();
        value = value.add(new BigDecimal("2.0"));
        System.out.println();
    }
    
    private void demo2(){
        Factory<BigDecimal> value = FactoryUtils.prototypeFactory(new BigDecimal("20"));
        System.out.println();
    }
}
