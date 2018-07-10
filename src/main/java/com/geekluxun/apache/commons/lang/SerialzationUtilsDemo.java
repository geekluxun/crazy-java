package com.geekluxun.apache.commons.lang;

import com.geekluxun.common.dto.RequestDto;
import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luxun
 * @Create: 2018-07-09 22:33
 * @Description:
 * @Other:
 */
public class SerialzationUtilsDemo {
    public static void main(String[] argc){
        SerialzationUtilsDemo demo = new SerialzationUtilsDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1(){
        Foo foo = new Foo();
        foo.setName("luxun");
        Map address = new HashMap();
        address.put("shanghai", "hello");
        foo.setAddress(address);
      
        Foo foo1 = new Foo();
        Foo foo2 = new Foo();
        try {
            // 浅拷贝
            foo1 = (Foo) foo.clone();
            // 通过序列化方式深拷贝
            foo2 = SerializationUtils.clone(foo);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        address.put("beijing", "hello");
        foo.setAddress(address);
        // foo1的address也跟着变了
        System.out.println("原有对象值改变后foo1值:" + foo1.getAddress());
        // foo2的address没有变
        System.out.println("原有对象值改变后foo2值:" + foo2.getAddress());
        System.out.println();
    }

    
    private void demo2(){
        Integer value = new Integer(10);
        // 序列化
        byte[] valueArray = SerializationUtils.serialize(value);
        // 反序列化
        Integer value2 = SerializationUtils.deserialize(valueArray);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        SerializationUtils.serialize(value, output);
        
        byte[] dd = output.toByteArray();

        InputStream inputStream = new ByteArrayInputStream(dd);
        // 反序列化
        Integer value3 = SerializationUtils.deserialize(inputStream);
        
        // 序列化 再反序列化
        Integer vavlue4 = SerializationUtils.roundtrip(value3);
        System.out.println();
    }

    /**
     * 内部类序列化必须定义成static 否则序列化反序列化会出问题!!!
     */
    @Data
    static class Foo implements Serializable ,Cloneable{
        String name;
        Map address;
        
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}

