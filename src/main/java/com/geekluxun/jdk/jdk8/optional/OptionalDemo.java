package com.geekluxun.jdk.jdk8.optional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-28 14:50
 * @Description:
 * @Other:
 */
public class OptionalDemo {
    public static void main(String[] argcs){
        demo1();
        demo2();
        demo3();
    }


    /**
     * Optional各种获取值的方式
     */
    private static void demo1(){
        // 值可空
        Optional<String> name = Optional.ofNullable(null);
        if (name.isPresent()){
            // get方法在值缺失时会抛异常 所以不能直接调，否则和NPE没有任何优势
            "luxun".equals(name.get());
        }
        // 如果空则使用默认值
        String nameStr = name.orElse("default");
        
        // 如果空则使用默认值 lamda表达式方式
        nameStr = name.orElseGet(()-> "default1122");
        
        System.out.println(nameStr);
        // Optional.of表示值不可空，如果null 此处会立即抛异常
        // Optional<String> name2 = Optional.of(null);
    }

    private static void demo2(){
        Person person = new Person();
        // 构造一个空值car 表示此人没有车（业务模型是允许的）
        Optional<Car> car = Optional.ofNullable(null);
        person.setCar(car);
        Optional<Person> personOptional = Optional.of(person);
        System.out.println("保险公司名：" + getInsuranceName(personOptional));
    }

    /**
     * 调用链上返回的任意一个Optional为空，则返回默认值"unKnown"
     * @param person
     * @return
     */
    private static String getInsuranceName(Optional<Person> person){
        return person.flatMap(Person::getCar)
            .flatMap(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("unKnown");    
    }
    
    
    private static void demo3(){
        Person person = new Person();
        Car car = new Car();
        Insurance insurance = new Insurance();
        insurance.setName("平安车险");
        car.setInsurance(Optional.of(insurance));
        car.setBrand("奔驰");
        person.setCar(Optional.ofNullable(car));
        person.setName("luxun");
        System.out.println("序列化：" + JSON.toJSONString(person, SerializerFeature.WRITE_MAP_NULL_FEATURES));
        
        System.out.println("反序列化开始:");
        Person person2 = JSON.parseObject("{name:\"luxun\",car:{insurance:{name:\"平安车险\"},brand:\"奔驰\"}}",Person.class);
        System.out.println("反序列化结束:" + JSON.toJSONString(person2));
    }
}
