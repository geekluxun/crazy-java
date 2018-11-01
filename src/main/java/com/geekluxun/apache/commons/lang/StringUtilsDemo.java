package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-05 16:40
 * @Description:
 * @Other:
 */
public class StringUtilsDemo {
    public static void main(String[] argc) {
        StringUtilsDemo demo = new StringUtilsDemo();
        demo.abbreviateDemo();
        demo.appendIfMissingDemo();
        demo.capitalizeDemo();
        demo.centerDemo();
        demo.chompDemo();
        demo.chopDemo();
        demo.compareDemo();
        demo.containsDemo();
        demo.indexOfAnyDemo();
        demo.subStringDemo();
        demo.countMatchesDemo();
        demo.defaultDemo();
        demo.differenceDemo();
        demo.equalDemo();
        demo.joinDemo();
    }

    /**
     * 尾部字符替换
     */
    private void abbreviateDemo() {
        // 返回"luxu..." 最少4个字符，其中...每次都占用3个字符
        String a1 = StringUtils.abbreviate("luxun-geek", 7);

        String a2 = StringUtils.abbreviate(null, 10);
        String a3 = StringUtils.abbreviate("", 4);
        String a4 = StringUtils.abbreviate("abcdefg", 6);
        String a5 = StringUtils.abbreviate("abcdefg", 7);
        String a6 = StringUtils.abbreviate("abcdefg", 8);
        String a7 = StringUtils.abbreviate("abcdefg", 4);
        //String a8 = StringUtils.abbreviate("abcdefg", 3);
        // 这个示例很常用，实际显示字符是6个，其中有效字符长度是3个，适合前端一些显示场景
        System.out.println(StringUtils.abbreviate("abcdefg", "...", 6));
        System.out.println();
    }

    /**
     * 给字符串增加一个尾缀
     */
    private void appendIfMissingDemo() {
        System.out.println(StringUtils.appendIfMissing(null, null));
        System.out.println(StringUtils.appendIfMissing("abc", null));
        System.out.println(StringUtils.appendIfMissing("", "xyz"));
        System.out.println(StringUtils.appendIfMissing("abc", "xyz"));
        System.out.println(StringUtils.appendIfMissing("abcxyz", "xyz"));
        System.out.println(StringUtils.appendIfMissing("abcXYZ", "xyz"));
    }

    private void capitalizeDemo() {
        // 首字符改成大写
        System.out.println(StringUtils.capitalize(null));
        System.out.println(StringUtils.capitalize(""));
        System.out.println(StringUtils.capitalize("cat"));
        System.out.println(StringUtils.capitalize("cAt"));
        System.out.println(StringUtils.capitalize("'cat'"));
    }

    /**
     * 已给定的字符串为中心,两头加space
     */
    private void centerDemo() {
        String a;
        a = StringUtils.center(null, 10);
        a = StringUtils.center("", 4);
        a = StringUtils.center("ab", -1);
        a = StringUtils.center("ab", 4);
        a = StringUtils.center("abcd", 2);
        a = StringUtils.center("a", 4);
        a = StringUtils.center("a", 5);

        System.out.println();
    }

    /**
     * 去掉回车换行符
     */
    private void chompDemo() {
        String a;
        a = StringUtils.chomp(null);
        a = StringUtils.chomp("");
        a = StringUtils.chomp("abc \r");
        a = StringUtils.chomp("abc\n");
        a = StringUtils.chomp("abc\r\n");
        a = StringUtils.chomp("abc\r\n\r\n");
        a = StringUtils.chomp("abc\n\r");
        a = StringUtils.chomp("abc\n\rabc");
        a = StringUtils.chomp("\r");
        a = StringUtils.chomp("\n");
        a = StringUtils.chomp("\r\n");
    }

    /**
     * 去掉最后一个字符
     */
    private void chopDemo() {
        String a;
        a = StringUtils.chop(null);
        a = StringUtils.chop("");
        a = StringUtils.chop("abc \r");
        a = StringUtils.chop("abc\n");
        a = StringUtils.chop("abc\r\n");
        a = StringUtils.chop("abc");
        a = StringUtils.chop("abc\nabc");
        a = StringUtils.chop("a");
        a = StringUtils.chop("\r");
        a = StringUtils.chop("\n");
        a = StringUtils.chop("\r\n");
    }

    /**
     * 字符串比较 解决了JDK中抛NPE问题 所谓NULL安全版本
     */
    private void compareDemo() {
        int a;
        try {
            // 此处会抛npe
            a = "luxun".compareTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 和jdk不同之处在于此处回返回1，前面大
        a = StringUtils.compare("luxun", null);
        a = StringUtils.compare(null, null);
        a = StringUtils.compare(null, "a");
        a = StringUtils.compare("a", null);
        a = StringUtils.compare("abc", "abc");
        a = StringUtils.compare("a", "b");
        a = StringUtils.compare("b", "a");
        // 返回的是31 不是 1 !!!
        a = "a".compareTo("B");
        a = StringUtils.compare("a", "B");
        a = StringUtils.compare("ab", "abc");
        // 表示null 和任何字符比较都小
        a = StringUtils.compare("a", null, true);
        a = StringUtils.compare("a", null, false);

        // 忽略大小写
        a = StringUtils.compareIgnoreCase("abc", "ABC");
        System.out.println();
    }


    /**
     * JDK中contains NULL安全版本
     */
    private void containsDemo() {
        String str = "luxun";
        System.out.println(StringUtils.containsAny(str, 'a', 'b', 'c'));
        boolean result;
        try {
            result = "dd".contains(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // null安全
        result = StringUtils.contains(null, "dd");
        result = StringUtils.contains("adc", null);
        result = StringUtils.contains("", "");
        result = StringUtils.contains("abc", "");
        result = StringUtils.contains("abc", "a");
        result = StringUtils.contains("abc", "z");

        System.out.println();

        // 不包含
        result = StringUtils.containsNone(null, "ab");
        //result = StringUtils.containsNone("ab", null);
        result = StringUtils.containsNone("", "d");
        result = StringUtils.containsNone("ab", ' ');
        result = StringUtils.containsNone("abab", 'x');
        result = StringUtils.containsNone("ab1", 'y');
        result = StringUtils.containsNone("abz", 'z');

        // 返回第一个串开始前n个不重复内容是否包含该在第2个串中
        result = StringUtils.containsOnly(null, "luxun");
        //StringUtils.containsOnly("luxun", null);       
        result = StringUtils.containsOnly("", "luxun");
        result = StringUtils.containsOnly("ab", "");
        // 开始的"abd" 包含在第2个中，返回true
        result = StringUtils.containsOnly("abdab", "adbc");
        result = StringUtils.containsOnly("ab1", "abc");
        result = StringUtils.containsOnly("abz", "ddabzc");

        result = StringUtils.containsWhitespace("    dd");
        System.out.println();
    }

    /**
     * 字符串位置
     */
    private void indexOfAnyDemo() {
        int index;
        index = StringUtils.indexOfAny(null, 'd');
        index = StringUtils.indexOfAny("", 'a');
        //StringUtils.indexOfAny("dd", null);
        index = StringUtils.indexOfAny("abc", ' ');
        index = StringUtils.indexOfAny("zzabyycdxx", 'z', 'a');
        index = StringUtils.indexOfAny("zzabyycdxx", 'b', 'y');
        index = StringUtils.indexOfAny("aba", 'z');

        index = StringUtils.indexOfAny(null, "luxun");
        index = StringUtils.indexOfAny("", "ddd");
        // TODO 如何解决？
        //index = StringUtils.indexOfAny("dd", null);           
        index = StringUtils.indexOfAny("dd", "");
        index = StringUtils.indexOfAny("zzabyycdxx", "za");
        index = StringUtils.indexOfAny("zzabyycdxx", "by");
        index = StringUtils.indexOfAny("aba", "z");

        // 任何一个不在前一个参数字符中的index
        StringUtils.indexOfAnyBut(null, 'a');
        StringUtils.indexOfAnyBut("", 'd');
        //StringUtils.indexOfAnyBut("abc", null);                             
        StringUtils.indexOfAnyBut("dd", new char[]{});
        StringUtils.indexOfAnyBut("zzabyycdxx", new char[]{'z', 'a'});
        StringUtils.indexOfAnyBut("aba", new char[]{'z'});
        StringUtils.indexOfAnyBut("aba", new char[]{'a', 'b'});
        System.out.println();
    }

    /**
     * subString 安全版本
     */
    private void subStringDemo() {
        String s;
        s = StringUtils.substring(null, 3);
        s = StringUtils.substring("", 2);
        s = StringUtils.substring("abc", 0);
        s = StringUtils.substring("abc", 2);
        s = StringUtils.substring("abc", 4);
        s = StringUtils.substring("abc", -2);
        s = StringUtils.substring("abc", -4);
        // 从某个位置开始取len个字符
        s = StringUtils.mid(null, 1, 3);
        s = StringUtils.mid("", 1, -3);
        s = StringUtils.mid("", 0, 3);
        s = StringUtils.mid("abc", 0, 2);
        s = StringUtils.mid("abc", 0, 4);
        s = StringUtils.mid("abc", 2, 4);
        s = StringUtils.mid("abc", 4, 2);
        s = StringUtils.mid("abc", -2, 2);
        System.out.println();
    }

    /**
     * 字符或字符串匹配的次数
     */
    private void countMatchesDemo() {
        int count;
        count = StringUtils.countMatches(null, ' ');
        count = StringUtils.countMatches("", 'd');
        count = StringUtils.countMatches("abba", ' ');
        count = StringUtils.countMatches("abba", 'a');
        count = StringUtils.countMatches("abba", 'b');
        count = StringUtils.countMatches("abba", 'x');
        System.out.println();
    }

    /**
     * 各种默认值
     */
    private void defaultDemo() {
        String s;
        // blank 表示空白 " "都算空白 empty表示空，空字符串是，但是space不是empty
        s = StringUtils.defaultIfBlank(null, "NULL");
        s = StringUtils.defaultIfBlank("", "NULL");
        s = StringUtils.defaultIfBlank(" ", "NULL");
        s = StringUtils.defaultIfBlank("bat", "NULL");
        s = StringUtils.defaultIfBlank("", null);

        s = StringUtils.defaultIfEmpty(null, "NULL");
        s = StringUtils.defaultIfEmpty("", "NULL");
        s = StringUtils.defaultIfEmpty(" ", "NULL");
        s = StringUtils.defaultIfEmpty("bat", "NULL");
        s = StringUtils.defaultIfEmpty("", null);
        // 返回""
        s = StringUtils.defaultString(null);
        s = StringUtils.defaultString("");
        s = StringUtils.defaultString("bat");

        s = StringUtils.defaultString(null, "NULL");
        s = StringUtils.defaultString("", "NULL");
        s = StringUtils.defaultString("bat", "NULL");

        System.out.println();
    }

    /**
     * 返回第2个字符串和第1个字符串不同开始以后的字符串
     */
    private void differenceDemo() {
        String s;
        s = StringUtils.difference(null, null);
        s = StringUtils.difference("", "");
        s = StringUtils.difference("", "abc");
        s = StringUtils.difference("abc", "");
        s = StringUtils.difference("abc", "abc");
        s = StringUtils.difference("abc", "ab");
        s = StringUtils.difference("ab", "abxyz");
        s = StringUtils.difference("abcde", "abxyz");
        s = StringUtils.difference("abcde", "xyz");

        System.out.println();
    }

    private void equalDemo() {
        boolean result;
        result = StringUtils.equalsAny(null, (CharSequence[]) null);
        result = StringUtils.equalsAny(null, null, null);
        result = StringUtils.equalsAny(null, "abc", "def");
        result = StringUtils.equalsAny("abc", null, "def");
        result = StringUtils.equalsAny("abc", "abc", "def");
        result = StringUtils.equalsAny("abc", "ABC", "DEF");
    }

    /**
     * 两个字符串的共同前缀
     */
    private void getCommonPrefix() {
        String s;
        s = StringUtils.getCommonPrefix(null);
        s = StringUtils.getCommonPrefix(new String[]{});
        s = StringUtils.getCommonPrefix(new String[]{"abc"});
        s = StringUtils.getCommonPrefix(new String[]{null, null});
        s = StringUtils.getCommonPrefix(new String[]{"", ""});
        s = StringUtils.getCommonPrefix(new String[]{"", null});
        s = StringUtils.getCommonPrefix(new String[]{"abc", null, null});
        s = StringUtils.getCommonPrefix(new String[]{null, null, "abc"});
        s = StringUtils.getCommonPrefix(new String[]{"", "abc"});
        s = StringUtils.getCommonPrefix(new String[]{"abc", ""});
        s = StringUtils.getCommonPrefix(new String[]{"abc", "abc"});
        s = StringUtils.getCommonPrefix(new String[]{"abc", "a"});
        s = StringUtils.getCommonPrefix(new String[]{"ab", "abxyz"});
        s = StringUtils.getCommonPrefix(new String[]{"abcde", "abxyz"});
        s = StringUtils.getCommonPrefix(new String[]{"abcde", "xyz"});
        s = StringUtils.getCommonPrefix(new String[]{"xyz", "abcde"});
        s = StringUtils.getCommonPrefix(new String[]{"i am a machine", "i am a robot"});
    }

    private void joinDemo() {
        String s;
        //StringUtils.join(null, "dd");
        s = StringUtils.join(new byte[]{}, ';');
        //StringUtils.join(new byte[]{null}, "dd");
        s = StringUtils.join(new byte[]{1, 2, 3}, ';');
        s = StringUtils.join(new char[]{'1', '2', '3'}, ' ');
        s = StringUtils.deleteWhitespace(s);
        System.out.println();
    }

}
