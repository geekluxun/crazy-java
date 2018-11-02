package com.geekluxun.jdk.util.scanner;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: luxun
 * @Create: 2018-11-01 13:43
 * @Description:
 * @Other:
 */
public class ScannerDemo {
    private Pattern pattern = Pattern.compile("[b-f]");

    private static String input = "a fish b fish 1 fish 2 fish d";
    public static void main(String[] argc){
        ScannerDemo demo = new ScannerDemo();
        demo.demo1();
        demo.demo2();
    }

    public void demo1(){
        Scanner scanner = new Scanner(input);
        // 分隔符fish扫描
        scanner = scanner.useDelimiter("\\s*fish\\s*");

        String next;
        while (scanner.hasNext()) {
            next = scanner.next();
            System.out.println(next);
        }
    }

    public void demo2(){
        Scanner scanner = new Scanner(input).useDelimiter(pattern);
        String next;
        while (scanner.hasNext()) {
            next = scanner.next();
            System.out.println(next);
        }
    }
}
