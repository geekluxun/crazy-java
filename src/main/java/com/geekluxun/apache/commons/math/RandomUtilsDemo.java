package com.geekluxun.apache.commons.math;


import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;

import java.util.Random;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-19 11:23
 * @Description: 随机数
 * @Other:
 */
public class RandomUtilsDemo {
    public static void main(String[] argc){
        RandomUtilsDemo demo = new RandomUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        RandomGenerator randomGenerator = RandomGeneratorFactory.createRandomGenerator(new Random());
        for (int i = 0; i < 10; i++){
            int random = randomGenerator.nextInt();
            System.out.println("随机整数:" + random);
        }
        

        RandomDataGenerator generator = new RandomDataGenerator();
        for (int i = 0; i < 10; i++){
            System.out.println("随机16进制:" + generator.nextHexString(10));
        }

        for (int i = 0; i < 10; i++){
            System.out.println("安全随机整数:" + generator.nextSecureInt(10, 100));
        }
        // 重置种子
        generator.reSeed();
        
    }
}
