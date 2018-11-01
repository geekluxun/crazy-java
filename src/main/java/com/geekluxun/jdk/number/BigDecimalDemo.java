package com.geekluxun.jdk.number;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 10:32
 * @Description:
 * @Other:
 */
public class BigDecimalDemo {
    public static void main(String[] argcs) {
        BigDecimalDemo decimalDemo = new BigDecimalDemo();
        //decimalDemo.demo1();
        decimalDemo.demo2();
    }

    private void demo1() {
        BigDecimal value1 = new BigDecimal("10.0");
        BigDecimal value2 = new BigDecimal("10.00");
        // equals要求是value和scale都等 才等！！！容易踩得的坑 !!!不要用equals比较值！！！
        System.out.println(value1.equals(value2));
        // compareTo 只要求 value等即可
        System.out.println(value1.compareTo(value2) == 0);
    }

    private void demo2() {
        BigDecimal value1 = new BigDecimal("0.005215511");
        //value1 = value1.setScale(8);
        // 原有精度是9位，此处改成8位，一定要设置Rounding，否则抛异常
        value1 = value1.setScale(8, RoundingMode.UP);
        System.out.println("value:" + value1.toString());
        System.out.println("value:" + value1.toPlainString());
        System.out.println("value:" + value1.toEngineeringString());
        System.out.println("=========");
        value1 = new BigDecimal("0");
        value1 = value1.setScale(10);
        System.out.println("value:" + value1.toString());
        System.out.println("value:" + value1.toPlainString());
        System.out.println("value:" + value1.toEngineeringString());

    }
}
