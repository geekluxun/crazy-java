package com.geekluxun.apache.commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.HexDump;
import org.apache.commons.io.LineIterator;
import org.springframework.util.Assert;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.zip.CRC32;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-18 13:51
 * @Description:
 * @Other:
 */
public class FileUtilsDemo {
    public static void main(String[] argc) {
        FileUtilsDemo demo = new FileUtilsDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
        demo.demo5();
        demo.demo6();
        demo.demo7();
        demo.demo8();
    }

    public void demo1() {
        // "1 GB" 
        String size = FileUtils.byteCountToDisplaySize(1024 * 1024 * 1024 + 1);
        System.out.println("文件大小:" + size);
    }

    public void demo2() {
        URL url = getClass().getResource(getClass().getSimpleName() + ".class");
        File file = new File(url.getFile());
        long checksum = 0;
        try {
            checksum = FileUtils.checksumCRC32(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件CRC32校验和:" + checksum);

        try {
            long checksum2 = FileUtils.checksum(file, new CRC32()).getValue();
            Assert.isTrue(checksum == checksum2, "校验和不同");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demo3() {
        File file = new File("/tmp");
        // 删除整个目录
        try {
            if (file.isDirectory()) {
                FileUtils.deleteDirectory(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file1 = new File("/1.txt");
        File file2 = new File("/2.txt");
        try {
            // 比较两个文件的内容是否相同
            boolean result = FileUtils.contentEquals(file1, file2);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void demo4() {
        File file1 = new File("/dd");
        try {
            FileUtils.copyDirectory(file1, new File("/dd2"));
            // 从一个URL 获取资源 保存到本地文件中
            FileUtils.copyURLToFile(new URL("http://www.baidu.com"), new File("/baidu.html"));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demo5() {
        // 因为目录不存在 无法创建此文件
        File file = new File("/luxun/luxun.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileUtils.forceMkdirParent(file);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 类似 /11/22
        File file1 = FileUtils.getFile("/11", "22");
        try {
            FileUtils.forceMkdirParent(file1);
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File tmp = FileUtils.getTempDirectory();
        System.out.println("临时文件路径:" + tmp.getPath());
        System.out.println("用户目录：" + FileUtils.getUserDirectoryPath());
        System.out.println();
    }

    public void demo6() {
        try {
            // 迭代出来的只有文件不包含目录
            Iterator<File> fileIterator =  FileUtils.iterateFiles(new File("/da"), null, true);
            while (fileIterator.hasNext()){
                System.out.println("文件路径:" +fileIterator.next().getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void demo7(){
        try {
            LineIterator iterator = FileUtils.lineIterator(new File("/2.txt"));
            while (iterator.hasNext()){
                System.out.println("文件内容:" + iterator.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void demo8(){
        byte[] data = new byte[]{1,2,3,4};
        try {
            OutputStream os = new FileOutputStream("/22.txt");  
            // 16进制形式dump字节数组到输出流中
            HexDump.dump(data,0, os, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}    