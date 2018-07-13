package com.geekluxun.apache.commons.collections;

import lombok.Data;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 10:54
 * @Description: 比较器工具类
 * @Other:
 */
public class ComparatorUtilsDemo {
    public static void main(String[] argc){
        ComparatorUtilsDemo demo = new ComparatorUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return CompareToBuilder.reflectionCompare(o1, o2);
            }
        };
        comparator = ComparatorUtils.nullHighComparator(comparator);
        //comparator = ComparatorUtils.nullLowComparator(comparator);

        Person person1 = null;
        Person person2 = new Person();
        // 上面的比较器定义null比所有值都大 返回的value > 0
        int value = java.util.Objects.compare(person1, person2, comparator);
        System.out.println();
        
        // 自然序
        ComparatorUtils.naturalComparator();
        // 颠倒排序规则
        ComparatorUtils.reversedComparator(comparator);
        // 先转换 再排序
        ComparatorUtils.transformedComparator(comparator, new Transformer<Object, Person>() {
            @Override
            public Person transform(Object o) {
                return null;
            }
        });
        
    }
    
    @Data
    private static class Person{
        String name;
        Integer age;
    }
    
}
