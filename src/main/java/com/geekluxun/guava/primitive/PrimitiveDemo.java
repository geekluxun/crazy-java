package com.geekluxun.guava.primitive;

import com.google.common.primitives.Chars;
import com.google.common.primitives.Ints;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-03 11:30
 * @Description: java原生类型工具类
 * @Other:
 */
public class PrimitiveDemo {
    public static void main(String[] argc){
        PrimitiveDemo demo = new PrimitiveDemo();
        demo.demo1();
        demo.demo2();
    }

    /**
     * Ints工具类
     */
    private void demo1(){
        Ints.asList(1,2,3);

        try {
            // 超过Integer.Max 或者小于 Integer.Min 抛异常
            int a = Ints.checkedCast(100000000000L);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        
        int b = Ints.compare(1, 10);
        Assert.isTrue(b < 0);
        
        byte[] c = Ints.toByteArray(10);
        // 大端模式解析字节数组
        int d = Ints.fromByteArray(c);
        System.out.println();
    }
    
    
    private void demo2(){
        List<Character> c = Chars.asList('l', 'u', 'x', 'u', 'n');   
        // 数组型转uncode字符
        char d = Chars.checkedCast(500);
        
        // 注意，只取数组的前2个字节，代表unicode编码
        byte[] b = new byte[10];
        b[0] = 0x54;
        b[1] = 0x32;
        b[2] = 0x7f;
        b[3] = 0x42;
        Character d1 = Chars.fromByteArray(b);
        // 连接成 "a-b-c"
        String dd = Chars.join("-", 'a', 'b', 'c');
        
        System.out.println();

    }
}
