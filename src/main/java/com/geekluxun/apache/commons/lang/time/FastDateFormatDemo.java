package com.geekluxun.apache.commons.lang.time;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-11 14:59
 * @Description:
 * @Other:
 */
public class FastDateFormatDemo {
    public static void main(String[] argc) {
        FastDateFormatDemo demo = new FastDateFormatDemo();
        demo.demo1();
        demo.demo2();
    }

    /**
     * 是JDK中SimpleDataFormat 线程安全版本
     */
    private void demo1() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance();
        String date = fastDateFormat.format(new Date());

        fastDateFormat = FastDateFormat.getDateInstance(FastDateFormat.SHORT);
        date = fastDateFormat.format(new Date());

        fastDateFormat = FastDateFormat.getDateInstance(FastDateFormat.MEDIUM);
        date = fastDateFormat.format(new Date());

        // "2018年7月11日"
        fastDateFormat = FastDateFormat.getDateInstance(FastDateFormat.LONG);
        date = fastDateFormat.format(new Date());

        fastDateFormat = FastDateFormat.getDateInstance(FastDateFormat.FULL);
        date = fastDateFormat.format(new Date());

        fastDateFormat = FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.LONG);
        date = fastDateFormat.format(new Date());

        // "2018-7-11 14:33:34"
        fastDateFormat = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.MEDIUM);
        date = fastDateFormat.format(new Date());

        date = fastDateFormat.format(Calendar.getInstance());
        // 格式化时间戳
        date = fastDateFormat.format(1531292166000L);

        // 以下两个方法返回的结果一致
        fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        date = fastDateFormat.format(new Date());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = simpleDateFormat.format(new Date());
        System.out.println();
    }

    /**
     * 解析时间
     */
    private void demo2() {
        // 日期
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse("2018-07-11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 时间
        format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        try {
            date = format.parse("2018-07-11 14:22:25");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
