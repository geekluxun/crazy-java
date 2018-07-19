package com.geekluxun.jdk.io.Serializable;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-19 16:36
 * @Description:
 * @Other:
 */
public class SerializableDemo implements Serializable{
    private String name = "luxun";
    public static void main(String[] argc){
        SerializableDemo demo = new SerializableDemo();
        demo.demo1();
        demo.demo2();
    }
    
    private void demo1(){
        // 需要实现get set方法才能序列化为JSON
        String dd = JSON.toJSONString(this);
        System.out.println();
    }

    /**
     * 序列化，反序列化示例
     */
    private void demo2(){
        try {
            // 序列化
            String fileName = "/data.txt";
            FileOutputStream os = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(os);
            outputStream.writeObject(new Foo());
            outputStream.flush();
            outputStream.close();
            // 反序列化
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            Foo foo = (Foo)inputStream.readObject();
            // 从文件中反序列化出对象
            foo.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
