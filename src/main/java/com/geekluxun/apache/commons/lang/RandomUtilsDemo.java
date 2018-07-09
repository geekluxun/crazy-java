package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.RandomStringUtils;

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
        System.out.println();
    }
}
