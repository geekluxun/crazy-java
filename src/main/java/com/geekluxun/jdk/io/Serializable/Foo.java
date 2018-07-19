package com.geekluxun.jdk.io.Serializable;

import java.io.Serializable;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-19 17:20
 * @Description:
 * @Other:
 */
public class Foo implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void doSomething(){
        System.out.println("我被执行了！");
    }
}
