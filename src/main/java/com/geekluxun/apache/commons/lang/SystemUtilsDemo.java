package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 11:16
 * @Description:
 * @Other:
 */
public class SystemUtilsDemo {
    public static void main(String[] argc){
        SystemUtilsDemo demo = new SystemUtilsDemo();
        demo.demo1();
    }
    
    private void demo1(){
        String name = SystemUtils.getHostName();
        File file  = SystemUtils.getJavaHome();
        file = SystemUtils.getJavaIoTmpDir();
        // 用户目录 E:\workspace\me\crazy-java
        file = SystemUtils.getUserDir();
        // C:\Users\luxun
        file = SystemUtils.getUserHome();
        Boolean isJava8 = SystemUtils.IS_JAVA_1_8;
        Boolean isWindows = SystemUtils.IS_OS_WINDOWS;
        String clasPath = SystemUtils.JAVA_CLASS_PATH;
        String classVersion = SystemUtils.JAVA_CLASS_VERSION;
        String runtimeName = SystemUtils.JAVA_RUNTIME_NAME;
        String vmInfo = SystemUtils.JAVA_VM_INFO;
        String vmName = SystemUtils.JAVA_VM_NAME;
        // 用户名
        String userName = SystemUtils.USER_NAME;
        String userTimeZone = SystemUtils.USER_TIMEZONE;
        System.out.println();
    }
}
