package com.geekluxun.apache.commons.collections;

import org.apache.commons.collections4.EnumerationUtils;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 11:35
 * @Description:
 * @Other:
 */
public class EnumerationUtilsDemo {
    public static void main(String[] argc){
        EnumerationUtilsDemo demo = new EnumerationUtilsDemo();
        demo.demo1();
        demo.demo2();
    }
    
    private void demo1(){
        Hashtable hashtable = new Hashtable();
        hashtable.put("key1", 1);
        hashtable.put("key2", 2);
        hashtable.put("key3", 3);
        hashtable.put("key4", 4);
        Enumeration<Integer> enumeration = hashtable.elements();
        
        // 转换成list
        List<Integer> list = EnumerationUtils.toList(enumeration);
        System.out.println();
    }
    
    private void demo2(){
        String str = " hello,java,delphi,asp,php";
        StringTokenizer st=new StringTokenizer(str,",");
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        // StringTokenizer转换成list
        List<String> list = EnumerationUtils.toList(st);
        System.out.println();
    }
}
