package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-09 11:34
 * @Description: 随机数相关
 * @Other:
 */
public class RandomUtilsDemo {
    public static void main(String[] argc){
        RandomUtilsDemo demo = new RandomUtilsDemo();
        demo.demo1();
        demo.demo2();
    }
    
    private void demo1(){
        String random;
        // 16个字符
        random = RandomStringUtils.random(16);
        // 字母 数字
        random = RandomStringUtils.random(16,true,true);
        
        random = RandomStringUtils.random(16, 'a','b', 'c', 'd');
        // A-F
        random = RandomStringUtils.random(16, 65, 70,true, true);
        
        // 从给定字符集中选取部分字符
        random = RandomStringUtils.random(16, 1, 3,true,true, 'a', 'b', 'c', 'd');

        random = RandomStringUtils.randomAlphabetic(10);

        // 字符串的最小长度和最大长度之间
        random = RandomStringUtils.randomAlphabetic(1, 10);
        // 固定长度 可见ascii字符 10个32~126之间
        random = RandomStringUtils.randomAscii(10);

        random = RandomStringUtils.randomAscii(1, 10);

        random = RandomStringUtils.randomNumeric(10);

        random  = RandomStringUtils.randomNumeric(1, 10);

        random = RandomStringUtils.randomGraph(10);
        // 可打印assii字符 包括空格等
        random = RandomStringUtils.randomPrint(10);

        System.out.println();
    }

    private void demo2(){
        byte[] array = RandomUtils.nextBytes(10);
        int valueInt = RandomUtils.nextInt(1, 10);
        double valueDouble = RandomUtils.nextDouble(10, 20);

        System.out.println();
    }
}
