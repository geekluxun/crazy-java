package com.geekluxun.design.patterns.command;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 17:04
 * @Description: 命令真正执行者
 * @Other:
 */
public class Light {
    
    public void on(){
        System.out.println("灯打开");
    }
    
    public void off(){
        System.out.println("灯关闭");
    }
}
