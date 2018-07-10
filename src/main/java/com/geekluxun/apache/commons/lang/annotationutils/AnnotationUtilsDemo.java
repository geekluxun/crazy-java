package com.geekluxun.apache.commons.lang.annotationutils;

import org.apache.commons.lang3.AnnotationUtils;

import java.lang.annotation.Annotation;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-06 15:09
 * @Description:
 * @Other:
 */
@TestAnnotation1(value = "luxun")

public class AnnotationUtilsDemo {
    public static void main(String[] argc){
        AnnotationUtilsDemo demo = new AnnotationUtilsDemo();
        demo.demo1();
    }
    @TestAnnotation1(value = "luxun")
    public void demo1(){
        boolean result = false;
        // 注解实例都是代理，两个注解相等需要所有type和method都相等
        Annotation a1 = this.getClass().getAnnotation(TestAnnotation1.class);
        Annotation a2 = null;
        try {
            a2 = this.getClass().getMethod("demo1").getAnnotation(TestAnnotation1.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // 此处返回ture
        try {
            result = AnnotationUtils.equals(a1, a2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 两个hashcode相等
        int hashcode1 = AnnotationUtils.hashCode(a1);
        int hashcode2 = AnnotationUtils.hashCode(a2);

        System.out.println(AnnotationUtils.toString(a1));
        System.out.println(result);
    }
}
