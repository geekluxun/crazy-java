package com.geekluxun.apache.commons.lang.builder;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 13:34
 * @Description: 产生hashcode
 * @Other:
 */
public class HashCodeBuilderDemo {
    public static void main(String[] argc){
        HashCodeBuilderDemo demo = new HashCodeBuilderDemo();
        demo.demo1();
    }
    
    private void demo1(){
        Boolean result = new Boolean(true);
        // 1231
        int hashcode = result.hashCode();
        // 1237
        result = new Boolean(false);
        hashcode = result.hashCode();

        HashCodeBuilder builder = new HashCodeBuilder(17, 37);
        builder = builder.append(true);
        hashcode = builder.toHashCode();
        builder.append(10);
        System.out.println();
    }
}
