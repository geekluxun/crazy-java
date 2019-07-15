package com.geekluxun.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-22 14:13
 * @Description: 文件工具类
 * @Other:
 */
@Slf4j
public class FileUtils {

    public static void main(String[] argc) {
        readFileAndSort("D:\\22.txt");
    }

    public static byte[] readFile(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        int len = (int) file.length();
        byte[] data = new byte[len];

        try {
            FileInputStream in = new FileInputStream(file);
            int read = 0;
            while (read < len) {
                try {
                    read += in.read(data, read, len - read);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }


    /**
     * 读取文件然后排序
     *
     * @param fileName
     * @return
     */
    public static String readFileAndSort(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }

        List<LineValue> myValueList = new ArrayList<LineValue>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                String line = reader.readLine();
                String[] values = line.split(",");
                LineValue value = new LineValue();
                value.setCount(values[0]);
                value.setDate(Long.valueOf(values[1]));
                myValueList.add(value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        log.info("排序前所有的数据");
        for (LineValue data : myValueList) {
            System.out.println(data.getDate() + " " + data.getCount());
        }

        myValueList = myValueList.stream().sorted(Comparator.comparing(LineValue::getDate)).collect(Collectors.toList());
        log.info("排序后所有的数据");
        for (LineValue data : myValueList) {
            System.out.println(data.getDate() + " " + data.getCount());
        }
        return null;

    }

    /**
     * 获取某一个目录下所有文件名
     *
     * @param fileDir
     * @return
     */
    public static List<String> getFileNames(String fileDir) {
        List<String> fileNames = new ArrayList<>();
        File root = new File(fileDir);

        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                fileNames.addAll(getFileNames((file.getAbsolutePath())));
            } else {
                fileNames.add(file.getAbsolutePath());
            }
        }

        return fileNames;
    }


    @Data
    public static class LineValue {
        private String count;
        private Long date;
    }
}
