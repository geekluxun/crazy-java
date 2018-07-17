package com.geekluxun.jdk.util.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 13:44
 * @Description:
 * @Other:
 */
public class ZipFileDemo {

    public static void main(String[] argc) {
        ZipFileDemo demo = new ZipFileDemo();
        // user.dir指定了当前的路径
        System.out.println(System.getProperty("user.dir"));
        demo.unzip(System.getProperty("user.dir"), "tmp.zip", "/da");
    }

    /**
     * 通过ZipFile解压缩文件
     */
    public void unzip(String zipFileDir, String zipFileName, String unzipDir) {
        String zipFilePath = zipFileDir + File.separator + zipFileName;
        try {
            System.out.println("zipFilePath = " + zipFilePath);
            ZipFile zipFile = new ZipFile(zipFilePath);
            // 先创建解压根目录
            File unzipFile = new File(unzipDir);
            unzipFile.mkdirs();

            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    System.out.print("dir  : " + entry.getName());
                    String destPath = unzipDir + File.separator + entry.getName();
                    System.out.println(" => " + destPath);
                    File file = new File(destPath);
                    file.mkdirs();
                } else {
                    String destPath = unzipDir + File.separator + entry.getName();
                    File file = new File(destPath);
                    // 这种语法写的比较特别！！！
                    try (InputStream inputStream = zipFile.getInputStream(entry);
                         FileOutputStream outputStream = new FileOutputStream(file)
                    ) {
                        int data = inputStream.read();
                        while (data != -1) {
                            outputStream.write(data);
                            data = inputStream.read();
                        }
                    }
                    System.out.println("file : " + entry.getName() + " => " + destPath);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error unzipping file " + zipFilePath, e);
        }
    }
}
