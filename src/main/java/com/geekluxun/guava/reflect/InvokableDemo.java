package com.geekluxun.guava.reflect;

import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-04 10:33
 * @Description: 反射示例
 * @Other:
 */
public class InvokableDemo {
    public static void main(String[] argc) {
        InvokableDemo demo = new InvokableDemo();
        demo.demo1();
    }

    private void demo1() {

        Method method = null;
        try {
            // 只是public方法
            method = CustomClass.class.getMethod("somePublicMethod");
        } catch (NoSuchMethodException e) {
            System.out.println("没有这个方法");
            throw new RuntimeException(e);
        }

        // 反射调用方法
        try {
            method.invoke(new CustomClass());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Invokable<CustomClass, ?> invokable = new TypeToken<CustomClass>() {
        }.method(method);
        // 判断是不是公共方法 JDK和Guava两种实现
        System.out.println(Modifier.isPublic(method.getModifiers()));
        System.out.println(invokable.isPublic());

        try {
            method = CustomClass.class.getMethod("notOverridablePublicMethod");
        } catch (NoSuchMethodException e) {
            System.out.println("没有这个方法");
            throw new RuntimeException(e);
        }
        invokable = new TypeToken<CustomClass>() {
        }.method(method);
        // 判断是不是overriade方法 JDK和Guava两种实现
        boolean isOverridableStandardJava = (!(Modifier.isFinal(method.getModifiers())
                || Modifier.isPrivate(method.getModifiers())
                || Modifier.isStatic(method.getModifiers())
                || Modifier.isFinal(method.getDeclaringClass().getModifiers())));
        boolean isOverridableFinalGauava = invokable.isOverridable();

        Assert.isTrue(!isOverridableStandardJava);
        Assert.isTrue(!isOverridableFinalGauava);

        System.out.println(invokable.isPublic());
        System.out.println(invokable.getDeclaringClass());
        System.out.println(invokable.getParameters());
        System.out.println(invokable.getOwnerType());
        System.out.println(invokable.getExceptionTypes());
        System.out.println(invokable.getReturnType());
        System.out.println(invokable.getModifiers());
        System.out.println(invokable.getName());
        System.out.println(invokable.isOverridable());
        System.out.println(invokable.isVarArgs());
        System.out.println(invokable.isPublic());
        System.out.println(invokable.isAbstract());
        System.out.println(invokable.isAccessible());
        System.out.println(invokable.isAnnotationPresent(Override.class));
        System.out.println(invokable.isStatic());

        // 反射调用方法
        try {
            invokable.invoke(new CustomClass());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public class CustomClass {
        public void somePublicMethod() {
            System.out.println("======somePublicMethod被调用了======");
        }

        public final void notOverridablePublicMethod() {
            System.out.println("======notOverridablePublicMethod被调用了======");
        }
    }
}
