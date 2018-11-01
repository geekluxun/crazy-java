package com.geekluxun.jdk.lang;

import java.util.Map;
import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 14:10
 * @Description:
 * @Other:
 */
public class SystemDemo {
    public static void main(String[] argc) {
        SystemDemo demo = new SystemDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1() {
        // Java 运行时环境版本
        System.out.println(System.getProperty("java.version"));
        // Java 运行时环境供应商
        System.out.println(System.getProperty("java.vendor"));
        // Java 供应商的 URL
        System.out.println(System.getProperty("java.vendor.url"));
        // Java 安装目录
        System.out.println(System.getProperty("java.home"));
        // Java 虚拟机规范版本
        System.out.println(System.getProperty("java.vm.specification.version"));
        // Java 虚拟机规范供应商
        System.out.println(System.getProperty("java.vm.specification.vendor"));
        // Java 虚拟机规范名称
        System.out.println(System.getProperty("java.vm.specification.name"));
        // Java 虚拟机实现版本
        System.out.println(System.getProperty("java.vm.version"));
        // Java 虚拟机实现供应商
        System.out.println(System.getProperty("java.vm.vendor"));
        // Java 虚拟机实现名称
        System.out.println(System.getProperty("java.vm.name"));
        // Java 运行时环境规范版本
        System.out.println(System.getProperty("java.specification.version"));
        // Java 运行时环境规范供应商
        System.out.println(System.getProperty("java.specification.vendor"));
        // Java 运行时环境规范名称
        System.out.println(System.getProperty("java.specification.name"));
        // Java 类格式版本号
        System.out.println(System.getProperty("java.class.version"));
        // Java 类路径
        System.out.println(System.getProperty("java.class.path"));
        // 加载库时搜索的路径列表
        System.out.println(System.getProperty("java.library.path"));
        // 默认的临时文件路径
        System.out.println(System.getProperty("java.io.tmpdir"));
        // 要使用的 JIT 编译器的名称
        System.out.println(System.getProperty("java.compiler"));
        // 一个或多个扩展目录的路径
        System.out.println(System.getProperty("java.ext.dirs"));
        // 操作系统的名称
        System.out.println(System.getProperty("os.name"));
        // 操作系统的架构
        System.out.println(System.getProperty("os.arch"));
        // 操作系统的版本
        System.out.println(System.getProperty("os.version"));
        // 文件分隔符（在 UNIX 系统中是“/”）
        System.out.println(System.getProperty("file.separator"));
        // 路径分隔符（在 UNIX 系统中是“:”）
        System.out.println(System.getProperty("path.separator"));
        // 行分隔符（在 UNIX 系统中是“/n”
        System.out.println(System.getProperty("line.separator"));
        // 用户的账户名称
        System.out.println(System.getProperty("user.name"));
        // 用户的主目录
        System.out.println(System.getProperty("user.home"));
        // 用户的当前工作目录
        System.out.println(System.getProperty("user.dir"));

    }

    private void demo2() {
        // 所有的环境变量
        Map env = System.getenv();
        Set<Map.Entry<String, String>> entries = env.entrySet();
        entries.forEach((e) -> System.out.println("key:" + e.getKey() + " value:" + e.getValue()));

        SecurityManager securityManager = System.getSecurityManager();
        // 指定对象的hashcode
        int hashcode = System.identityHashCode(this);
        System.out.println();
    }
}
