package com.geekluxun.apache.commons.lang.time;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-12 13:49
 * @Description:
 * @Other:
 */
public class DurationFormatUtilsDemo {
    public static void main(String[] argc) {
        DurationFormatUtilsDemo demo = new DurationFormatUtilsDemo();
        demo.demo1();
    }

    //    character	duration element
//    y	years
//    M	months
//    d	days
//    H	hours
//    m	minutes
//    s	seconds
//    S	milliseconds
//    'text'	arbitrary text content
    private void demo1() {
        // 格式HH:mm:ss.SSS
        String durationTime = DurationFormatUtils.formatDurationHMS(new Date().getTime());
        // 8天
        durationTime = DurationFormatUtils.formatDuration(1000 * 60 * 60 * 24 * 8, "d");

        durationTime = DurationFormatUtils.formatDurationISO(1000 * 60 * 60 * 24 * 8);

        Date dateStart = new Date();
        Date dataEnd = DateUtils.addDays(dateStart, 20);
        // 两个时间相差20天
        durationTime = DurationFormatUtils.formatPeriod(dateStart.getTime(), dataEnd.getTime(), "d");

        durationTime = DurationFormatUtils.formatPeriod(dateStart.getTime(), dataEnd.getTime(), "H");

        System.out.println();
    }
}
