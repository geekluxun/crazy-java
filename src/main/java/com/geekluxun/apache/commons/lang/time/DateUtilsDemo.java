package com.geekluxun.apache.commons.lang.time;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import static java.util.Calendar.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-11 15:07
 * @Description:
 * @Other:
 */
public class DateUtilsDemo {
    public static void main(String[] argc) {
        DateUtilsDemo demo = new DateUtilsDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
        demo.demo5();
        demo.demo6();
    }

    private void demo1() {
        Date date = DateUtils.addDays(new Date(), 21);
        date = DateUtils.addHours(new Date(), 15);
        // 天向上取值 其他舍去
        date = DateUtils.ceiling(new Date(), DAY_OF_MONTH);
        // 向下取值 小时以下舍去  2018-07-11 15:35:10 变成 2018-07-11 00:00:00
        Calendar calendar = DateUtils.round(Calendar.getInstance(), HOUR);
        // 变成2018-07-11 15:35:10 变成 2018-07-12 00:00:00
        calendar = DateUtils.round(Calendar.getInstance(), DAY_OF_MONTH);
        // 月是从0开始的
        calendar.set(2018, 06, 11, 15, 20, 30);
        date = calendar.getTime();
        calendar = DateUtils.round(calendar, MINUTE);
        // 变成了2018-07-11 15:21:00
        date = calendar.getTime();
        System.out.println();
    }

    private void demo2() {
        // 有效取值 field
        // Calendar.YEAR, 
        // Calendar.MONTH,
        // Calendar.DAY_OF_YEAR 
        // Calendar.DATE, 
        // Calendar.HOUR_OF_DAY,
        // Calendar.MINUTE, 
        // Calendar.SECOND
        // Calendar.MILLISECOND
        // 当前日期2018-07-11 返回192 表示是1年中的第几天
        long value = DateUtils.getFragmentInDays(new Date(), Calendar.YEAR);
        // 在月中的第几天 返回11
        value = DateUtils.getFragmentInDays(new Date(), Calendar.MONTH);
        // 返回0 因为第2个参数已经超过小于等于“天”
        value = DateUtils.getFragmentInDays(new Date(), Calendar.DAY_OF_MONTH);
        // 2018-07-11 16:17:00  返回16
        value = DateUtils.getFragmentInHours(new Date(), Calendar.DAY_OF_MONTH);
        value = DateUtils.getFragmentInHours(new Date(), Calendar.YEAR);
        System.out.println();
    }

    private void demo3() {
        // 截断
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse("2017-06-04 00:56:05");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = DateUtils.truncate(date, Calendar.YEAR); // 2017-01-01 00:00:00  
        date = DateUtils.truncate(date, Calendar.MONTH); // 2017-06-01 00:00:00  
        // 24小时制
        date = DateUtils.truncate(date, Calendar.HOUR_OF_DAY); // 2017-06-04 00:00:00  
        date = DateUtils.truncate(date, Calendar.DAY_OF_MONTH); // 2017-06-04 00:00:00  
        // 12小时制
        date = DateUtils.truncate(date, Calendar.HOUR); // 2017-06-04 00:00:00  
        date = DateUtils.truncate(date, Calendar.MINUTE); // 2017-06-04 00:56:00  
        date = DateUtils.truncate(date, Calendar.SECOND); // 2017-06-04 00:56:05 

        // 向下取整
        try {
            date = format.parse("2017-06-04 00:44:41");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = DateUtils.round(date, Calendar.YEAR); // 2017-01-01 00:00:00  
        date = DateUtils.round(date, Calendar.MONTH); // 2017-06-01 00:00:00  
        date = DateUtils.round(date, Calendar.HOUR_OF_DAY); // 2017-06-04 01:00:00  
        date = DateUtils.round(date, Calendar.DAY_OF_MONTH); // 2017-06-04 00:00:00  
        date = DateUtils.round(date, Calendar.HOUR); // 2017-06-04 01:00:00  
        date = DateUtils.round(date, Calendar.MINUTE); // 2017-06-04 00:45:00  
        date = DateUtils.round(date, Calendar.SECOND); // 2017-06-04 00:44:43  

        // 向上取整
        try {
            date = format.parse("2017-06-04 01:02:31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = DateUtils.ceiling(date, Calendar.YEAR); // 2018-01-01 00:00:00  
        date = DateUtils.ceiling(date, Calendar.MONTH); // 2017-07-01 00:00:00  
        date = DateUtils.ceiling(date, Calendar.HOUR_OF_DAY); // 2017-06-04 02:00:00  
        date = DateUtils.ceiling(date, Calendar.DAY_OF_MONTH); // 2017-06-05 00:00:00  
        date = DateUtils.ceiling(date, Calendar.HOUR); // 2017-06-04 02:00:00  
        date = DateUtils.ceiling(date, Calendar.MINUTE); // 2017-06-04 01:03:00  
        date = DateUtils.ceiling(date, Calendar.SECOND); // 2017-06-04 01:02:32 
        System.out.println();
    }

    private void demo4() {
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss:SSS");
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        try {
            date1 = format.parse("2018-07-11 01:02:31:100");
            date2 = format.parse("2018-07-11 13:02:31:200");
            date3 = format.parse("2018-07-11 13:02:31:300");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 忽略时间部分
        boolean result = DateUtils.isSameDay(date1, date2);

        // 两个时间戳是否相等(精确到毫秒)
        long time2 = date2.getTime();
        long time3 = date3.getTime();
        result = DateUtils.isSameInstant(date2, date3);

        Date date4 = new Date();
        Date date5 = new Date();
        long time4 = date4.getTime();
        long time5 = date5.getTime();
        result = DateUtils.isSameInstant(date4, date5);

        System.out.println();
    }

    private void demo5() {
        try {
            // 迭代一周 从最近的一个周一开始
            Iterator<Calendar> iterator = DateUtils.iterator(new Date(), DateUtils.RANGE_WEEK_MONDAY);
            while (iterator.hasNext()) {
                Calendar calendar = iterator.next();
                System.out.println("日期1：" + calendar.getTime());
            }

            // 从当前日期开始迭代一周
            iterator = DateUtils.iterator(new Date(), DateUtils.RANGE_WEEK_RELATIVE);
            while (iterator.hasNext()) {
                Calendar calendar = iterator.next();
                System.out.println("日期2：" + calendar.getTime());
            }

            // 以当前日期为中心迭代一周
            iterator = DateUtils.iterator(new Date(), DateUtils.RANGE_WEEK_CENTER);
            while (iterator.hasNext()) {
                Calendar calendar = iterator.next();
                System.out.println("日期3：" + calendar.getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定格式解析时间
     */
    private void demo6() {
        Date date = null;
        try {
            date = DateUtils.parseDate("2018-07-11 01:02:31:100", "yyyy-MM-dd HH:mm:ss:SSS");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
