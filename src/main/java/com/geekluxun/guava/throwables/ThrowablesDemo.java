package com.geekluxun.guava.throwables;

import com.geekluxun.common.exception.MyException;
import com.google.common.base.Throwables;

import java.io.UnsupportedEncodingException;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 13:56
 * @Description: 异常处理示例
 * @Other:
 */
public class ThrowablesDemo {
    
    public static void main(String[] argc){
        ThrowablesDemo throwablesDemo = new ThrowablesDemo();
        throwablesDemo.demo1();
        throwablesDemo.deme3();
    }
    
    private void demo1() {
        try {
            byte[] data = "luxun".getBytes("utf3=");
        } catch (UnsupportedEncodingException e) {
            // 当e是RuntimeException Error 或者MyException时重新抛出异常 此处不会抛！！！
            Throwables.propagateIfPossible(e, MyException.class);
        }
    }
    
    private void demo2(){
        try {
            throw new MyException("异常1");
        } catch (Exception e) {
            // 当e是RuntimeException Error 或者MyException时重新抛出异常 此处会抛！！！
            Throwables.propagateIfPossible(e,  MyException.class);
        }
    }
    
    private void deme3(){
        try {
            throw new MyException("异常2");
        } catch (Exception e) {
            // 当e是RuntimeException时重新抛出
            Throwables.throwIfUnchecked(e);
        }
    }
    
}
