package com.geekluxun.apache.commons.lang.AnnotationUtils;

import lombok.Data;
import org.apache.commons.lang3.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-06 15:09
 * @Description:
 * @Other:
 */

public class AnnotationUtilsDemo {
    public static void main(String[] argc){
        AnnotationUtilsDemo demo = new AnnotationUtilsDemo();
        demo.demo1();
    }

    @TestAnnotation1(value = "dd")
    @TestAnnotation2(value = "lu")
    public void demo1(){
        boolean result;
        try {
            result = AnnotationUtils.equals(getClass().getAnnotation(TestAnnotation1.class),  getClass().getAnnotation(TestAnnotation1.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
