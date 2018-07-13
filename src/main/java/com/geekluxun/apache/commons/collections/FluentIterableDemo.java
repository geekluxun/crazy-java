package com.geekluxun.apache.commons.collections;


import com.google.common.collect.Lists;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.TransformerUtils;

import java.util.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 14:09
 * @Description:
 * @Other:
 */
public class FluentIterableDemo {
    public static void main(String[] argc){
        FluentIterableDemo demo = new FluentIterableDemo();
        demo.demo1();
        demo.demo2();
    }
    
    private void demo1() {
        // 体验一把流式
        List<String> list = FluentIterable.of(1,2,3,4,5,6,7,8,9,10).filter(new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer number) {
                return number % 2 == 0;
            }
        })
        .transform(TransformerUtils.stringValueTransformer())
        .limit(3)
        .toList();
        System.out.println();
    }
    
    private void demo2(){
        FluentIterable<Integer> fluent = FluentIterable.of(1,2,3,4,5);
        fluent = fluent.append(6,8,9,8);
        Integer[] array = fluent.toArray(Integer.class);
        Enumeration<Integer> enumeration = fluent.asEnumeration();
        
        // 增加
        fluent = fluent.collate(Lists.newArrayList(8,9,10));

        List list = new ArrayList();
        // 拷贝到list
        fluent.copyInto(list);
        Iterator iterator = fluent.iterator();
        fluent.size();
        // 去重
        fluent = fluent.unique();
        fluent = fluent.unmodifiable();
        fluent = fluent.append(12);
        System.out.println();
    }
}
