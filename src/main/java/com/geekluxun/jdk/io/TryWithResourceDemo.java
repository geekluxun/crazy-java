package com.geekluxun.jdk.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-03 14:50
 * @Description:  try with resources结构示例 避免了 try finally 关闭资源的问题
 * @Other:
 */
public class TryWithResourceDemo {
    public static void main(String[] argc) throws IOException {
        TryWithResourceDemo demo = new TryWithResourceDemo();  
        demo.demo1();
    }
    
    private void demo1() throws IOException {
        
        try(InputStream in = ClassLoader.getSystemResourceAsStream("application.properties");){
            byte[] buffer  = new byte[in.available()];
            // 已读字节
            int readed = 0; 
            int len = buffer.length;
            while (readed < len){
                // 最后一个参数表示本次读的字节数
                readed += in.read(buffer, readed, len - readed);
            }
            System.out.println(Arrays.asList(buffer));
        }
    }
}
