package com.geekluxun.web;

import com.geekluxun.apache.commons.io.IOUtilsDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-18 13:15
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/httptest")
public class HttpRequestResponseController {
    @Autowired
    IOUtilsDemo ioUtilsDemo;
    
    @RequestMapping("/test3")
    public String test3(HttpServletRequest request) {
        try {
            ioUtilsDemo.demo2();
            ioUtilsDemo.demo3();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "uploadfile";
    }
    /**
     * 响应体由两部分组成，一个是response输出流中的内容，一个是渲染的网页!!!
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/test4")
    public String test4(HttpServletRequest request, HttpServletResponse response){
        try {
            ioUtilsDemo.demo4(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "uploadfile";
    }

    @RequestMapping("/test9")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        try {
            ioUtilsDemo.demo9(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "uploadfile";
    }
}
