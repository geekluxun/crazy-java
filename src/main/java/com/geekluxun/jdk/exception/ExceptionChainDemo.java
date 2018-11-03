package com.geekluxun.jdk.exception;


import org.assertj.core.api.Assertions;

/**
 * @Author: luxun
 * @Create: 2018-11-01 14:11
 * @Description: java异常链示例
 * @Other:
 */
public class ExceptionChainDemo {
    public static void main(String[] argc) throws Exception {
        ExceptionChainDemo demo = new ExceptionChainDemo();
        // 判断是某一种类型异常
        Assertions.assertThatThrownBy(() -> demo.demo1()).isInstanceOf(MyException2.class);
        System.out.println("dd");
    }

    private void demo1() throws Exception {
        fun1();
    }

    private void fun1() throws MyException1 {
        System.out.println("method1:");
        try {
            fun2();
        } catch (MyException2 e) {
            // 此处构成了异常链，异常1是由异常2引起的...
            throw new MyException1("fun1异常", e);
        }
    }

    private void fun2() throws MyException2 {
        throw new MyException2("fun2异常");
    }

}
