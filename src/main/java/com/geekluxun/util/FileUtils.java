package com.geekluxun.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-22 14:13
 * @Description: 文件工具类
 * @Other:
 */
public class FileUtils {
    
    public static byte[] readFile(File file){
        if (file == null || !file.exists()){
            return null;
        }
        int len = (int)file.length();
        byte[] data = new byte[len];
        
        try {
            FileInputStream in = new FileInputStream(file);
            int read = 0;
            while (read < len){
                try {
                    read += in.read(data,read,len - read);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return data;
    }
}
