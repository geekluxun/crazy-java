package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 16:19
 * @Description:
 * @Other:
 */
public class NumberUtilsDemo {
    public static void main(String[] argc){
        NumberUtilsDemo demo = new NumberUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        long value = NumberUtils.createLong("133");
        // 整形数值型
        boolean result = NumberUtils.isDigits("31");
        // 是否是数值型
        result = NumberUtils.isCreatable("3.1");
        
        // 字符串转数值型
        float value2 = NumberUtils.toFloat("33.22", 0);
        System.out.println();
    }
}
