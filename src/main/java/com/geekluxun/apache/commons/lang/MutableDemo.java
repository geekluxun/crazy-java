package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.mutable.MutableInt;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 16:43
 * @Description: 可变类型示例
 * @Other:
 */
public class MutableDemo {
    public static void main(String[] argc){
        MutableDemo demo = new MutableDemo();
        demo.demo1();
    }
    
    private void demo1(){
        MutableInt value = new MutableInt(1);
        func1(value);
        System.out.println("value;" + value.getValue());
    }

    /**
     * 这个方法改变了形参的值
     * @param value
     */
    private void func1(MutableInt value){
        value.add(20);
    }
}
