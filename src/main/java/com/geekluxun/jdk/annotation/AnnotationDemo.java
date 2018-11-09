package com.geekluxun.jdk.annotation;

import java.lang.reflect.Method;

/**
 * @Author: luxun
 * @Create: 2018-11-07 11:47
 * @Description:
 * @Other:
 */

public class AnnotationDemo {
    private static final String ANNOTATION_METHOD = "annotationData";

    public static void main(String[] argc) throws NoSuchMethodException {
        AnnotationDemo demo = new AnnotationDemo();
        demo.demo1();
    }


    public void demo1() throws NoSuchMethodException {
        // 这个方法是什么？？
        Method method = Class.class.getDeclaredMethod(ANNOTATION_METHOD);
    }
}
