package com.geekluxun.guava.math;

import com.google.common.math.IntMath;

import java.math.RoundingMode;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-03 17:59
 * @Description:
 * @Other:
 */
public class MathDemo {
    public static void main(String[] argc){
        MathDemo mathDemo = new MathDemo();
        mathDemo.demo1();
    }
    
    private void demo1(){
        // 2的指数
        System.out.println(IntMath.isPowerOfTwo(8));
        System.out.println(IntMath.log2(4, RoundingMode.UP));
        System.out.println(IntMath.log10(100, RoundingMode.DOWN));
        System.out.println(IntMath.pow(2,4));
        // 平方根
        System.out.println(IntMath.sqrt(9, RoundingMode.DOWN));
        // 向上取整 4
        System.out.println(IntMath.divide(10, 3,RoundingMode.UP));
        // 取模
        System.out.println(IntMath.mod(10, 6));
        // 最大公约数
        System.out.println(IntMath.gcd(10, 8));
        // 返回两数之和 超过范围抛出异常
        try {
            System.out.println(IntMath.checkedAdd(2000000000, 2000000000));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        // 返回两数之积 超过范围抛出异常
        try {
            System.out.println(IntMath.checkedMultiply(Integer.MAX_VALUE, Integer.MAX_VALUE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回两数之差 超过范围抛出异常
        try {
            System.out.println(IntMath.checkedSubtract(Integer.MIN_VALUE, Integer.MAX_VALUE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 阶乘 5*4*3*2*1= 120
        System.out.println(IntMath.factorial(5));
        // 二项式系数
        System.out.println(IntMath.binomial(10, 3));
    }

    private void demo2(){

    }
}
