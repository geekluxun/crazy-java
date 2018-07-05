package com.geekluxun.apache.commons.beanutils;

import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-05 9:03
 * @Description:
 * @Other:
 */
public class BeanUtilsDemo {
    public static void main(String[] argc){
        BeanUtilsDemo demo = new BeanUtilsDemo();
        demo.demo1();
        
    }
    
    private void demo1(){
        Foo1 foo1 = new Foo1();
        foo1.setA("luxun");
        foo1.setB(BigDecimal.valueOf(10));
        foo1.setD(2);
        
        Foo2 foo2 = new Foo2();
        try {
            /**
             *  Apache 的BeanUitils有一个坑，两个bean必须是public才能拷贝
             *  用spring提供的就没有这个问题！！！
             */
            BeanUtils.copyProperties(foo2, foo1);
            org.springframework.beans.BeanUtils.copyProperties(foo1, foo2);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        System.out.println();
    } 
    
    @Data
    class Foo1{
        private String a;
        private BigDecimal b;
        private boolean c;
        private int d;
    }
    
    @Data
    class Foo2 {
        private String a;
        private BigDecimal b;
        private boolean c;
        private int e;
    }
}
