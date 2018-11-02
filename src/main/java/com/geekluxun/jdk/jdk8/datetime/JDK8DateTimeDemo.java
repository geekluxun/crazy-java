package com.geekluxun.jdk.jdk8.datetime;

import org.apache.commons.configuration2.YAMLConfiguration;

import java.time.*;
import java.util.Date;

/**
 * @Author: luxun
 * @Create: 2018-11-01 14:31
 * @Description:
 * @Other:
 */
public class JDK8DateTimeDemo {
    public static void main(String[] argc){
        JDK8DateTimeDemo demo = new JDK8DateTimeDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1(){
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        System.out.println("");
    }

    private void demo2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println();

        // 转换成Date
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        System.out.print("date:" + date);
    }
}
