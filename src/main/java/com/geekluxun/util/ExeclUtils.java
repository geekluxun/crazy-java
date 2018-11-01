package com.geekluxun.util;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-02 11:15
 * @Description:
 * @Other:
 */
public class ExeclUtils {
    public static Workbook readLocalFile(String filePath) {
        try {
            InputStream in = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(in);
            return wb;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
