package com.geekluxun.guava.compare;

import com.google.common.collect.ComparisonChain;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 10:49
 * @Description: 比较器相关类示例
 * @Other:
 */
public class CompareDemo {
    public static void main(String[] argc){
        CompareDemo compareDemo = new CompareDemo();
        compareDemo.demo1();
    }
    
    private void demo1(){
        Person person = new Person();
        person.setName("鲁勋");
        person.setAge(10);
        person.setScore(BigDecimal.valueOf(100));
        Person person2 = new Person();
        person2.setName("luxun");
        person2.setAge(10);
        person2.setScore(BigDecimal.valueOf(100));
        int result = person.compareTo(person2);
        System.out.println(result);
    }
    
    private class Person implements Comparable<Person>{
        String name;
        Integer age;
        BigDecimal score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getScore() {
            return score;
        }

        public void setScore(BigDecimal score) {
            this.score = score;
        }
        
        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        /**
         * 使用这种流的形式可读性很强，而且是"懒式"比较，只要有一个比较不等，立即返回结果
         * @param person
         * @return
         */
        @Override
        public int compareTo(Person person) {
            return ComparisonChain.start()
                .compare(this.name, person.getName())
                .compare(this.age, person.getAge())
                .compare(this.score, person.getScore()).result();    
        }
    }
}
