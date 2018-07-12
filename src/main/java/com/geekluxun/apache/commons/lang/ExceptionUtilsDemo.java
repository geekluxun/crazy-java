package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 16:05
 * @Description:
 * @Other:
 */
public class ExceptionUtilsDemo {
    public static void main(String[] argc){
        ExceptionUtilsDemo demo = new ExceptionUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        Throwable throwable = new RuntimeException("ddd");
        
        String m = ExceptionUtils.getMessage(throwable);
        Throwable root = ExceptionUtils.getRootCause(throwable);
        m = ExceptionUtils.getRootCauseMessage(throwable);
        // 一直到此Throwable处的调用链
        String[] strings = ExceptionUtils.getRootCauseStackTrace(throwable);
        strings = ExceptionUtils.getStackFrames(throwable);
        int count = ExceptionUtils.getThrowableCount(throwable);
        List<Throwable> list = ExceptionUtils.getThrowableList(throwable);
        // 两者的区别
        //ExceptionUtils.rethrow(throwable);
        //ExceptionUtils.wrapAndThrow(throwable);
        System.out.println();
    }
}
