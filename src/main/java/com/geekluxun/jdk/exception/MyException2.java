package com.geekluxun.jdk.exception;

/**
 * @Author: luxun
 * @Create: 2018-11-01 14:13
 * @Description:
 * @Other:
 */
public class MyException2 extends Exception {

    public MyException2(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public MyException2(String msg) {
        super(msg);
    }
}
