package com.geekluxun.jdk.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

/**
 * Copyright,2019-2020,meituan Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019/10/19 8:34 下午
 * @Description:
 * @Other:
 */
public class ProcessBuilderDemo {

    public static void main(String[] argc) throws Exception {

        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("当前进程id:" + pid);
        fork();
    }

    public static void fork() throws Exception {
        //while (true) {
        System.out.println("当前用户:" + System.getProperty("user.name"));
        String shellPath = System.getProperty("user.dir") + "/" + "src/main/resources/script/mvntest.sh";
        String[] cmd = {"/bin/sh", shellPath};
        Process process = null;

        //process = Runtime.getRuntime().exec(cmd);
        ProcessBuilder builder = new ProcessBuilder("/bin/sh", shellPath);
        //builder.environment().put("MY_NAME", "geekluxun");
        try {
            process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("测试用例进程")) {
                    System.out.println("测试测试测试");
                }
            }
            System.out.println("结束....");
            //process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //process.destroy();
            System.out.println("结束---");
        }
        //}
    }
}
