package com.geekluxun.jdk.io.print;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Copyright,2019-2020,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019/10/28 9:37 下午
 * @Description:
 * @Other:
 */
public class PrintIoDemo {
    public static void main(String[] argc) {
        PrintIoDemo demo = new PrintIoDemo();
        demo.printWriteDemo();
    }

    public void printWriteDemo() {
        Throwable t = new Throwable("333", new Throwable("222", new Throwable("111")));
        StringWriter stringWriter = new StringWriter();
        // TODO autoFlush的效果如何？？
        PrintWriter printWriter = new PrintWriter(stringWriter, true);

        t.printStackTrace(printWriter);

        System.out.println("异常：" + stringWriter.toString());
    }
}
