package com.geekluxun.apache.commons.io;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-18 9:02
 * @Description:
 * @Other:
 */
@Service
public class IOUtilsDemo {
    public static void main(String[] argc) throws Exception {
        IOUtilsDemo demo = new IOUtilsDemo();
        demo.demo1();
        demo.demo8();
        demo.demo10();
        demo.demo11();
    }

    private void demo1() throws Exception {
        InputStream in = null;
        try {
            in = new URL("http://commons.apache.org").openStream();
            // 这个流其实就是返回的网页内容
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(inR);
            String line;
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 直接使用IOUtils方式
        try (InputStream in2 = new URL("http://commons.apache.org").openStream()) {
            String content = IOUtils.toString(in2, StandardCharsets.UTF_8);
            System.out.println(content);
        }

    }

    public void demo2() throws Exception {
        // 向此url发起get请求，返回的body
        String content = IOUtils.toString(new URL("http://localhost:8080/getuploadfile"), StandardCharsets.UTF_8);
        System.out.println("网页内容:" + content);
    }


    public void demo3() throws Exception {
        String content = IOUtils.toString(new URI("http://localhost:8080/getuploadfile"), StandardCharsets.UTF_8);
        System.out.println("网页内容:" + content);
    }

    public void demo4(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 不指名缓冲区大小，则是默认值8096
        BufferedInputStream in = IOUtils.buffer(request.getInputStream());
        byte[] buf = new byte[1024];
        // 从输入流中读取请求体注意 header中不能有Content-Type=application/x-www-form-urlencoded头!!!
        // 表单数据读取不是从流中读取，是通过getParamter方法
        in.read(buf, 0, 1024);
        String body = new String(buf);
        System.out.println("请求体:" + body);
        Writer writer = response.getWriter();
        // response body返回
        writer.write("hello world");
    }

    public void demo5(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 拷贝流
            IOUtils.copy(request.getInputStream(), response.getOutputStream());
            IOUtils.copy(request.getInputStream(), response.getWriter(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void demo6(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 行迭代
            LineIterator iterator = IOUtils.lineIterator(request.getInputStream(), StandardCharsets.UTF_8);
            while (iterator.hasNext()) {
                String content = iterator.nextLine();
                System.out.print(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void demo7(InputStream inputStream) {
        try {
            List<String> lines = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demo8() {
        try {
            // 此处必须指名ClassLoader， 否则会使用 默认的LaucherClassLoader 得不到资源!!!
            String content = IOUtils.resourceToString("templates/uploadfile.html", StandardCharsets.UTF_8, getClass().getClassLoader());
            URL resourceUrl = IOUtils.resourceToURL("templates/uploadfile.html", getClass().getClassLoader());
            // 文件的绝对路径
            String path = resourceUrl.getPath();
            System.out.println("资源内容:" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demo9(HttpServletRequest request, HttpServletResponse response) {
        try {
            byte[] content = IOUtils.toByteArray(request.getInputStream());
            System.out.println("请求体:" + new String(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demo10() {
        String data = "luxun123";
        InputStream in = IOUtils.toInputStream(data, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            System.out.println("流中数据:" + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把数据写入流
     */
    public void demo11() {

        try {
            OutputStream os = new ByteArrayOutputStream();
            IOUtils.write(new byte[]{1, 2, 3}, os);
            Collection<Object> c = new ArrayList<>();
            // 对每个item 调用toString 方法，每个行以'\n'作为行结束符 写入流...
            IOUtils.writeLines(c, "\n", os, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}