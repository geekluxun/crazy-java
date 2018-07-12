package com.geekluxun.apache.commons.lang.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.omg.DynamicAny._DynAnyFactoryStub;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-11 14:08
 * @Description: 
 * @Other:
 */
public class DateFormatUtilsDemo {
    public static void main(String[] argc){
        DateFormatUtilsDemo demo = new DateFormatUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        String date = DateFormatUtils.format(new Date(), DateFormatUtils.ISO_DATE_FORMAT.getPattern());
        
        System.out.println();
    }
}
