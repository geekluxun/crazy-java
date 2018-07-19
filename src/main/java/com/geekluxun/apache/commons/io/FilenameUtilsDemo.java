package com.geekluxun.apache.commons.io;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;

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
        demo.demo2();
        demo.demo3();
        demo.demo4();
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

    public void demo2(){
        try {
            boolean result = FilenameUtils.directoryContains("/a/b", "b");
            Assert.isTrue(!result, "");
            result = FilenameUtils.directoryContains("/a", "/a/b");
            Assert.isTrue(result, "不包含");
            // 大小写不敏感
            result = FilenameUtils.equals("/dd/A","/dD/a",true, IOCase.INSENSITIVE);

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demo3(){
        File file = new File("/dd/luxun.txt");
        String fileName = file.getPath();
        // -->luxun
        String str = FilenameUtils.getBaseName(fileName);
        str = FilenameUtils.getExtension(fileName);
        // -->/dd/
        str = FilenameUtils.getFullPath(fileName);
        // -->/dd
        str = FilenameUtils.getFullPathNoEndSeparator(fileName);
        // -->luxun.txt
        str = FilenameUtils.getName(fileName);
        // -->dd
        str = FilenameUtils.getPathNoEndSeparator(fileName);
        // -->/
        str = FilenameUtils.getPrefix(fileName);

        int len =  FilenameUtils.getPrefixLength(fileName);
        int index = FilenameUtils.indexOfExtension(fileName);
        int pos = FilenameUtils.indexOfLastSeparator(fileName);
        boolean result = FilenameUtils.isExtension(fileName, ".txt");
        System.out.println();
    }
    
    public void demo4(){
        String filename = FilenameUtils.normalize("//server/foo/../bar");
        // 尾部的分割符删掉
        filename = FilenameUtils.normalizeNoEndSeparator("//server/foo/../bar/");
        System.out.println();
        // 匹配
        boolean match = FilenameUtils.wildcardMatch("c.txt", "*.txt");
        match = FilenameUtils.wildcardMatch("c.txt", "*.????");
        System.out.println();
    }
}
