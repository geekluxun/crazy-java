package com.geekluxun.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-20 9:58
 * @Description:
 * @Other:
 */
public class CsvDemo {
    static List<Object> records;

    public static void main(String[] args) {
        CsvDemo demo = new CsvDemo();
        demo.createData();
        demo.saveRecords(records, "student.txt");
    }


    public <T> void saveRecords(List<T> records, String filePath) {

        Writer writer;
        try {
            OpenOption openOption;
            if (Files.exists(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS)) {
                openOption = StandardOpenOption.APPEND;
            } else {
                openOption = StandardOpenOption.CREATE;
            }
            writer = Files.newBufferedWriter(Paths.get(filePath), openOption);
            // 使用'|'分割符
            CSVFormat fromat = CSVFormat.newFormat('|');
            // 每个记录分割
            fromat = fromat.withRecordSeparator("\r\n");
            CSVPrinter csvPrinter = new CSVPrinter(writer, fromat);
            for (Object record : records) {
                Class c = record.getClass();
                Field[] fields = c.getDeclaredFields();
                List<Object> values = new ArrayList<>();
                for (int i = 0; i < fields.length; i++) {
                    String fieldName = fields[i].getName();
                    fieldName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                    Method method = c.getMethod(fieldName);
                    Object object = method.invoke(record);
                    values.add(object);
                }
                csvPrinter.printRecord(values);
            }

            csvPrinter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createData() {
        records = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        studentDto.setName("lxuun");
        studentDto.setAge(10);
        //studentDto.setSex("man");
        studentDto.setScore(new BigDecimal("100.00"));

        records.add(studentDto);
        studentDto = new StudentDto();
        studentDto.setName("lxuun222");
        //studentDto.setAge(10);
        studentDto.setSex("man");
        studentDto.setScore(new BigDecimal("100.00"));

        records.add(studentDto);
        studentDto = new StudentDto();
        studentDto.setName("lxuun333");
        studentDto.setAge(10);
        studentDto.setSex("man");
        studentDto.setScore(new BigDecimal("100.00"));
        records.add(studentDto);
    }

}
