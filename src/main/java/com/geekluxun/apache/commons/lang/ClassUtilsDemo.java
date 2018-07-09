package com.geekluxun.apache.commons.lang;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ClassUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-09 9:26
 * @Description:
 * @Other:
 */
public class ClassUtilsDemo {
    public static void main(String[] argc){
        ClassUtilsDemo demo = new ClassUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        String name ;
        Class myclass;
        List<String> names = ClassUtils.convertClassesToClassNames(Arrays.asList(String.class, Integer.class));
        // 类的简短名字 j.l.Boolean
        name = ClassUtils.getAbbreviatedName(Boolean.class, 10);
        
        List<Class<?>> classes = ClassUtils.getAllInterfaces(BigDecimal.class);
        classes = ClassUtils.getAllSuperclasses(BigDecimal.class);
        // 规范的名字
        String name2 = ClassUtils.getCanonicalName(BigDecimal.class);
        name2 = ClassUtils.getShortCanonicalName(BigDecimal.class);
        try {
            myclass = ClassUtils.getClass(getClass().getClassLoader(), "java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Iterable<?> iterable = ClassUtils.hierarchy(BigDecimal.class);
        iterable.forEach((a)->System.out.println("迭代：" + a));
        
        // 考虑了null
        boolean result = ClassUtils.isAssignable(BigDecimal.class, Number.class);
        BigDecimal value1 = BigDecimal.valueOf(10);
        Object value2 = new Object();
        if ((value1 instanceof Number)){
            System.out.println();
        }
        // false
        result = ClassUtils.isPrimitiveOrWrapper(BigDecimal.class);
        // true
        result = ClassUtils.isPrimitiveOrWrapper(int.class);

        System.out.println();
    }
}
