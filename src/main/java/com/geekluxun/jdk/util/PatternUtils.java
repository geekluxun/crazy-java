package com.geekluxun.jdk.util;

import java.util.regex.Pattern;

/**
 * @Author: luxun
 * @Create: 2019-07-16 21:27
 * @Description: 正则表达式
 * @Other:
 */
public class PatternUtils {
    private static String NUMBER_PATTERN = "^\\d+(\\.\\d+)?";

    private static String NUMBER_PATTERN2 = "-?[0-9]+(\\.[0-9]+)?";


    public static void main(String[] argc){
        System.out.println(PatternUtils.isNumber("2"));
        System.out.println(PatternUtils.isNumber("0"));

        System.out.println(PatternUtils.isNumber("0.00"));

        System.out.println(PatternUtils.isNumber("12.22"));

        System.out.println(PatternUtils.isNumber("22"));

        System.out.println(PatternUtils.isNumber("-233.22"));


    }
    public static boolean isNumber(String input) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN2);
        return pattern.matcher(input).matches();
    }

}
