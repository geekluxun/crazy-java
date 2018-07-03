package com.geekluxun.jdk.other;

import org.springframework.util.Assert;

import java.io.InputStream;
import java.net.URL;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-03 9:58
 * @Description:
 * @Other:
 */
public class ResourceLoaderDemo {
    public static void main(String[] argc){
        ResourceLoaderDemo demo = new ResourceLoaderDemo();
        demo.demo1();
    }
    
    
    private void demo1(){
        InputStream in = ClassLoader.getSystemResourceAsStream("application.properties");
        Assert.isTrue(!(in == null), "文件不存在");

        URL url = ClassLoader.getSystemResource("application.properties");
        System.out.println(url.getPath());
    }
}
