package com.geekluxun.apache.commons.lang;

import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
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
    }

    private void demo1(){
        Foo foo = new Foo();
        foo.setName("luxun");
        Map map = new HashMap();
        map.put("addrss", "hello");
        //foo.setAddress(map);
        Foo foo1 = SerializationUtils.clone(foo);
        //SerializationUtils.clone(new HashMap());
        System.out.println();
    }


    public class Foo implements Serializable {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //Map address;
    }
}
