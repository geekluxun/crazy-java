package com.geekluxun.web;

import com.geekluxun.apache.commons.io.IOUtilsDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
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


    @RequestMapping("/test1")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int value = request.getSession().getMaxInactiveInterval();
        return "uploadfile";
    }
    
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
    public String test9(HttpServletRequest request, HttpServletResponse response) {
        try {
            ioUtilsDemo.demo9(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "uploadfile";
    }

    @RequestMapping("/getuser")
    public void getuser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("sessionId:" + request.getSession().getId());
        System.out.println("getuser会话超时时间：" + request.getSession().getMaxInactiveInterval());
        String name = (String) request.getSession().getAttribute("name");
        System.out.println("name:" + name);
        if (name == null){
            System.out.println("会话超时了!!!");
        }
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("sessionId:" + request.getSession().getId());
        request.getSession().setMaxInactiveInterval(30);
        request.getSession().setAttribute("name", "luxun");
        System.out.println("login会话超时时间：" + request.getSession().getMaxInactiveInterval());
    }


}
