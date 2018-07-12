package com.geekluxun.guava.string;

import com.google.common.base.*;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-02 9:53
 * @Description: 字符串连接分割匹配示例
 * @Other:
 */
public class StringDemo {
    
    public static void main(String[] argc){
        StringDemo demo = new StringDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
    }
    
    private void demo1(){
        Joiner joiner = Joiner.on("; ").skipNulls();
        String reuslt = joiner.join("Harry", null, "Ron", "Hermione"); 
        
        System.out.println("reuslt1: " + reuslt);

        reuslt = Joiner.on(",").join(Arrays.asList(1, 5, 7));
        System.out.println("reuslt2: " + reuslt);
    }
    
    private void demo2(){
        String src = ",a,,b,";
        // jdk 方式分割 包含两个空字符
        String[] result = src.split(",");
        // 忽略空字符 trim掉所有空格
        Iterable<String> iterable  = Splitter.on(",").trimResults().omitEmptyStrings().split(src);
        
        List list = Lists.newArrayList(iterable);
        String[] a;
        a = (String[]) list.toArray(new String[list.size()]);
        System.out.println(a);
    }
    
    private void demo3(){
        String src = ",a,,b,cc; dd.ee ";
        
        Iterable<String> iterable = Splitter.on(CharMatcher.anyOf(",;.")).trimResults().omitEmptyStrings().split(src);
       
        List list = Lists.newArrayList(iterable);
        String[] a;
        a = (String[]) list.toArray(new String[list.size()]);
        System.out.println(a);
        // 正则表达式
        Splitter.onPattern("\\r?\\n");
        // 以每3个字符分割
        Lists.newArrayList(Splitter.fixedLength(3).split(src)).forEach((b)->System.out.println(b));
    }
    
    private void demo4(){
        // 字符匹配示例
        CharMatcher.anyOf("luxun");
        CharMatcher.ascii();
        CharMatcher.breakingWhitespace();
        CharMatcher.inRange('a', 'd');
        CharMatcher.noneOf("luxun");
        CharMatcher.whitespace();

        // 字符集
        byte[] bytes = "luxun".getBytes(Charsets.UTF_8);

        // returns "constantName"
        String dd = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"); 

    }

    /**
     * Strings工具类
     */
    private void demo5(){
        String s = Strings.nullToEmpty(null);
        boolean b = Strings.isNullOrEmpty("");
        s = Strings.padEnd("l",10, 'u');
        System.out.println();
    }
}
