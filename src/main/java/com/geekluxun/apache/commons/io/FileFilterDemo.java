package com.geekluxun.apache.commons.io;

import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.io.FileFilter;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-19 10:23
 * @Description: 各种文件过滤
 * @Other:
 */
public class FileFilterDemo {
    public static void main(String[] argc) {
        FileFilterDemo demo = new FileFilterDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
        demo.demo5();
        demo.demo6();
        demo.demo7();
        demo.demo8();
    }

    /**
     * 根据文件时间过滤
     */
    private void demo1() {
        // 当前路径下1天之类修改的
        File dir = new File(".");
        // We are interested in files older than one day
        long cutoff = System.currentTimeMillis() - (24 * 60 * 60 * 1000);
        String[] files = dir.list(new AgeFileFilter(cutoff));
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 可写文件过滤
     */
    public void demo2() {
        File dir = new File(".");
        String[] files = dir.list(CanWriteFileFilter.CAN_WRITE);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 不可写文件过滤
     */
    public void demo3() {
        File dir = new File(".");
        String[] files = dir.list(CanWriteFileFilter.CANNOT_WRITE);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 子目录过滤
     */
    public void demo4() {
        File dir = new File(".");
        String[] files = dir.list(DirectoryFileFilter.INSTANCE);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 空文件或目录过滤
     */
    public void demo5() {
        File dir = new File(".");
        String[] files = dir.list(EmptyFileFilter.EMPTY);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 是真正文件而不是目录的过滤
     */
    public void demo6() {
        File dir = new File(".");
        String[] files = dir.list(FileFileFilter.FILE);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 文件超过1M过滤
     */
    public void demo7() {
        File dir = new File(".");
        String[] files = dir.list(new SizeFileFilter(1024 * 1024));
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 文件名通配符过滤
     */
    public void demo8() {
        File dir = new File(".");
        FileFilter fileFilter = new WildcardFileFilter("*.xml");
        File[] files = dir.listFiles(fileFilter);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

}
