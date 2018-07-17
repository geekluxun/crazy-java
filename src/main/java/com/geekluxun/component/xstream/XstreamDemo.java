package com.geekluxun.component.xstream;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 14:49
 * @Description: Xstream实现javabean和xml的互转
 * @Other:
 */
public class XstreamDemo {
    public static void main(String[] argc) {
        XstreamDemo demo = new XstreamDemo();
        demo.demo1();
    }

    private void demo1() {
        XStream xstream = new XStream();
        // 注解
        xstream.autodetectAnnotations(true);
        Person person = new Person();
        person.setName("luxun");
        person.setAge(18);


        List<Person> girls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Person person2 = new Person();
            person2.setName("girl" + i);
            person2.setAge(18 + i);
            girls.add(person2);
        }

        person.setGirlFriends(girls);
        System.out.println("JSON:" + JSON.toJSONString(person));
        // JavaBean转换成XML
        String xmlStr = xstream.toXML(person);
        System.out.println("XML:" + xmlStr);
        // XML转换成JavaBean
        Person person2 = (Person) xstream.fromXML(xmlStr);
        System.out.println("person2:" + JSON.toJSONString(person2));

    }
}
