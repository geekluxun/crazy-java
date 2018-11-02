package com.geekluxun.jdk.exception;

/**
 * @Author: luxun
 * @Create: 2018-11-01 14:13
 * @Description:
 * @Other:
 */
public class MyException1 extends Exception {
    public MyException1(String msg, Throwable throwable){
        super(msg, throwable);
    }


    public MyException1(String msg){
        super(msg);
    }
}
