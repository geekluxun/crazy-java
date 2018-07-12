package com.geekluxun.jdk.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-03 16:31
 * @Description:
 * @Other:
 */
public class HashDemo {
    public static void main(String[] argc){
        HashDemo demo = new HashDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
    }
    
    private void demo1(){
        // 定义散列函数（用什么算法散列）
        HashFunction hf = Hashing.md5();
        // 对字符串转换成字节数组用上面的散列函数进行散列
        HashCode hc = hf.newHasher().putString("luxun",Charsets.UTF_8).hash();
        int code = hc.asInt();
        // 此处生成的hashcode是16字节(128bit)
        byte[] bytes = hc.asBytes();
        System.out.println("hashcode: " + hc.toString());
    }
    
    private void demo2(){
        String originalString = "luxun";
        HashFunction hf = Hashing.sha256();
        HashCode hc = hf.hashString(originalString, StandardCharsets.UTF_8);
        String sha256hex =hc.toString();
        // 此处生成的hashcode是32字节(256bit)
        byte[] bytes = hc.asBytes();

        String md5 = Hashing.md5().hashString("luxun", Charsets.UTF_8).toString();
        
        System.out.println("md5: " + md5);
    }
    
    private void demo3(){
        // 把一个对象分解成多个原生类型
        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person person, PrimitiveSink primitiveSink) {
                primitiveSink.putInt(person.id)
                        .putString(person.firstName, Charsets.UTF_8)
                        .putString(person.lastName, Charsets.UTF_8)
                        .putInt(person.birthYear);
            }
        } ;

        Person person = new Person();
        person.id = 1;
        person.firstName = "lu";
        person.lastName = "xun";
        person.birthYear = 111;
        HashFunction hf = Hashing.md5();
        // 需要计算hashcode的是一个Object ，需要先构造其对应的Funnel
        HashCode hc = hf.newHasher()
                .putObject(person, personFunnel)
                .hash();
        System.out.println("hashcode: " + hc.toString());
    }

    class Person {
        int id;
        String firstName;
        String lastName;
        int birthYear;
    }
    
    private void demo4(){
        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person person, PrimitiveSink primitiveSink) {
                primitiveSink.putInt(person.id)
                        .putString(person.firstName, Charsets.UTF_8)
                        .putString(person.lastName, Charsets.UTF_8)
                        .putInt(person.birthYear);
            }
        } ;
        List<Person> friendsList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Person person = new Person();
            person.id = i + 1;
            person.firstName = "lu";
            person.lastName = "xun";
            person.birthYear = 100;
            friendsList.add(person);
        }
        // 第2个参数 预期集合大小 第3个参数 容错率
        BloomFilter<Person> friends = BloomFilter.create(personFunnel, 500, 0.01);
        // 把原始集合放到过滤器中
        for (Person friend : friendsList) {
            friends.put(friend);
        }
        
        Person person2 = new Person();
        person2.id =  1;
        person2.firstName = "lu";
        person2.lastName = "xun";
        person2.birthYear = 100;
        // 验证此对象是否在集合中 返回true 因为对象的散列码相同
        boolean result = friends.mightContain(person2);
        System.out.println("布隆过滤器:" + result);
    }
}
