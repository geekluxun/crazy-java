package com.geekluxun.jdk.objects;

import sun.misc.ASCIICaseInsensitiveComparator;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 9:57
 * @Description: Objects工具类示例
 * @Other:
 */
public class ObjectsDemo {
    
    public static void main(String[] argc){
        demo1();
        //demo2();
        demo3();
    }

    /**
     * equal示例
     */
    private static void demo1(){
        // 正常情况下比较两个null会报NPE异常，这个方法不会
        System.out.println("比较两个null值：" + Objects.equals(null,null));
        System.out.println("其中一个为null值：" + Objects.equals("luxun",null));
    }

    /**
     * hash hashcode示例
     */
    private static void demo2(){
        Dd dd = new Dd();
        // 获取对象的hash值
        int hashcode = Objects.hashCode(dd);
        System.out.println(hashcode);
        
        // Warning: When a single object reference is supplied,
        // the returned value does not equal the hash code of that object reference. 
        // This value can be computed by calling hashCode(Object).
        int hash = Objects.hash(dd);
        System.out.println(hash);
        
        // 对输入的多个对象序列产生一个hash值 注意以下两种对象顺序不同，所以产生的的hash值不同！！！
        hash = Objects.hash("luxun", new BigDecimal("100"), new Integer(100));
        hash = Objects.hash(new BigDecimal("100"), "luxun" , new Integer(100));

        System.out.println(hash);
    }
    
    
    private static void demo3(){
        // 使用大小写敏感的比较器
        int result = Objects.compare("ab", "aa", new ASCIICaseInsensitiveComparator());
        System.out.println("compare:" + result);
    }
    
    
    private static class Dd{
        @Override
        public int hashCode() {
            return 1234;
        }
    }
}
