package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-09 10:53
 * @Description:
 * @Other:
 */
public class ObjectUtilDemo {
    public static void main(String[] argc){
        ObjectUtilDemo demo = new ObjectUtilDemo();
        demo.demo1();
    }
    
    private void demo1(){
        boolean result;
        // 所有不为空返回true
        result = ObjectUtils.allNotNull(new Integer[]{1, 2, null});
        // 任何一个不为null 返回true
        result = ObjectUtils.anyNotNull(new Integer[]{1,3 ,null, 3});
        // null 安全比较
        int value = ObjectUtils.compare(null, null);
        
        int a = ObjectUtils.CONST(100);
        Character c = ObjectUtils.defaultIfNull(null, 'l');
        
        StringBuilder builder = new StringBuilder();
        // 调用toString方法把值增加到builder中
        ObjectUtils.identityToString(builder, new BigDecimal("1.0"));

        // 通过占位符区分中以下两种null 不同含义
        Map map = new HashMap();
        map.put("name", ObjectUtils.NULL);
        
        System.out.println("有age:" + ObjectUtils.NULL == map.get("age"));
        System.out.println("有name:" + ObjectUtils.NULL == map.get("name"));

    }
}
