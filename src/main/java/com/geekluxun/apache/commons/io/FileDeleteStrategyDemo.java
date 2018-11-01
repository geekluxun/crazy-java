package com.geekluxun.apache.commons.io;

import org.apache.commons.io.ByteOrderParser;
import org.apache.commons.io.FileDeleteStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-19 9:19
 * @Description:
 * @Other:
 */
public class FileDeleteStrategyDemo {
    public static void main(String[] argc) {
        FileDeleteStrategyDemo demo = new FileDeleteStrategyDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1() {
        File file = new File("/dd2");
        // 强制删除 即使目录非空
        FileDeleteStrategy deleteStrategy = FileDeleteStrategy.FORCE;
        try {
            deleteStrategy.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 如果目录非空 则不删除 抛出异常
        deleteStrategy = FileDeleteStrategy.NORMAL;
        try {
            deleteStrategy.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 删除失败不会抛异常，转换成false
        boolean result = deleteStrategy.deleteQuietly(file);
        System.out.println();
    }

    public void demo2() {
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        ByteOrderParser.parseByteOrder("luxun");
        System.out.println();
    }
}
