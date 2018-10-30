package com.geekluxun.jdk.io.file;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-09-09 11:17
 * @Description:
 * @Other:
 */
public class FileTest {
    
    
    @Test
    public void test() throws Exception {
        System.out.println("pathSeparator:" + File.pathSeparator);
        System.out.println("pathSeparatorChar:" + File.pathSeparatorChar);
        System.out.println("separator:" + File.separator);
        System.out.println("separatorChar:" + File.separatorChar);    
    }

}