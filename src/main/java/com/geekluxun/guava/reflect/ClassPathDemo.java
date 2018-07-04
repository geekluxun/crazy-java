package com.geekluxun.guava.reflect;

import com.google.common.reflect.ClassPath;
import org.springframework.util.Assert;

import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-04 16:27
 * @Description: ClassPath示例
 * @Other:
 */
public class ClassPathDemo {
    public static void main(String[] argc){
        ClassPathDemo demo = new ClassPathDemo();
        demo.demo1();
        demo.demo2();
    }
    
    private void demo1(){
        ClassPath classpath = null;
        try {
            classpath = ClassPath.from(ClassLoader.getSystemClassLoader());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 某一个package下所有的class(递归方式)
        for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClassesRecursive("com.geekluxun")) {
            System.out.println(classInfo.getName());
            if (classInfo.getSimpleName().equals("TypeTokenDemo")){
                try {
                    Class typeTokenDemo = Class.forName(classInfo.getName());
                    Constructor constructor = typeTokenDemo.getConstructor();
                    java.lang.reflect.Method method = typeTokenDemo.getMethod("demo1");
                    // 先用构造函数生成一个对象，再调用demo1方法
                    method.invoke(constructor.newInstance());
                }  catch (Exception e) {
                    System.out.println(e);            
                }
                
                System.out.println();
            }
        }
        
        for (ClassPath.ClassInfo classInfo : classpath.getAllClasses()) {
            System.out.println(classInfo.getName());
        }
    }
    
    public void demo2(){
       ClassLoader classLoader = ClassLoader.getSystemClassLoader();
       ClassLoader classLoader2 = this.getClass().getClassLoader();
       Assert.isTrue(classLoader.equals(classLoader2), "用的是同一个ClassLoader");
       System.out.println();
    }
}
