package com.geekluxun.apache.commons.io;

import org.apache.commons.io.FilenameUtils;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-18 18:15
 * @Description:
 * @Other:
 */
public class FilenameUtilsDemo {
    public static void main(String[] argc){
        FilenameUtilsDemo demo = new FilenameUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        String path = FilenameUtils.concat("/foo/", "bar");
        path = FilenameUtils.concat("/foo", "bar");
        path = FilenameUtils.concat("/foo", "C:/bar");
        path = FilenameUtils.concat("/foo", "C:/bar");
        path = FilenameUtils.concat("/foo", "C:bar");
        path = FilenameUtils.concat("/foo/a/", "../bar");
        System.out.println();
    }
}
