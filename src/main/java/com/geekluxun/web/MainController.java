package com.geekluxun.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: luxun
 * @Create: 2018-07-02 20:59
 * @Description:
 * @Other:
 */
@Controller
public class MainController {

    /**
     * 测试servlet容器在系统中的路径
     * @param request
     * @param response
     */
    @RequestMapping("/test1")
    public void test(HttpServletRequest request, HttpServletResponse response){
        String path = request.getServletContext().getRealPath("/dd");
        System.out.println(path);
    }
}

