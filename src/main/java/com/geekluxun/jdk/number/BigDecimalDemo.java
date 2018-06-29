package com.geekluxun.jdk.number;

import javax.swing.text.Style;
import java.math.BigDecimal;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 10:32
 * @Description:
 * @Other:
 */
public class BigDecimalDemo {
    public static void main(String[] argcs){
        BigDecimalDemo decimalDemo = new BigDecimalDemo();
        decimalDemo.demo1();
    }
    
    private void demo1(){
        BigDecimal value1 = new BigDecimal("10.0");
        BigDecimal value2 = new BigDecimal("10.00");
        // equals要求是value和scale都等 才等！！！容易踩得的坑 !!!不要用equals比较值！！！
        System.out.println(value1.equals(value2));
        // compareTo 只要求 value等即可
        System.out.println(value1.compareTo(value2) == 0);
    }
}
