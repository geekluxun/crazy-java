package com.geekluxun.jdk.io.file;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-09-09 11:17
 * @Description:
 * @Other:
 */
public class FileTest {


    @Test
    public void test() throws Exception {
        // unix下是 ':' ，表示多个path之间的分割符号  /data:/data/3.txt
        System.out.println("pathSeparator:" + File.pathSeparator);
        System.out.println("pathSeparatorChar:" + File.pathSeparatorChar);
        // unix下是 '/', 表示文件路径分给符
        System.out.println("separator:" + File.separator);
        System.out.println("separatorChar:" + File.separatorChar);
    }

    @Test
    public void test2() throws Exception {
        File file = new File("lu.txt");
        if (file.exists()) {
            System.out.println("exist");
        } else {
            file.createNewFile();
            FileUtils.write(file, "ddd", StandardCharsets.UTF_8);
        }
        Assert.assertTrue(true);
    }

    @Test
    public void test3() throws Exception {
        Properties p = System.getProperties();
        System.out.println(p);
        String value = System.getProperty("geek");
        System.setProperty("geek", "geekluxun");
        value = System.getProperty("geek");

        Map env = System.getenv();
        env.entrySet().forEach(((e) -> System.out.println("key:" + ((Map.Entry) e).getKey() +
                " value:" + ((Map.Entry) e).getValue())));
        Set<Map.Entry> set = env.entrySet();
        File file = File.createTempFile("luxun", ".txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(System.getProperty("java.io.tmpdir"));
        Assert.assertEquals(file.getAbsolutePath(), System.getProperty("java.io.tmpdir") + "/luxun.txt");
    }

}