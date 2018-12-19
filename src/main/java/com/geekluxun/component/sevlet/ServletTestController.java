package com.geekluxun.component.sevlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-01 15:22
 * @Description:
 * @Other:
 */
@Controller("/servlet")
public class ServletTestController {

    /**
     * 通过servlet上下文获取资源文件示例
     *
     * @param request
     * @param response
     */
    @GetMapping("/test")
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        try {

            Set<String> paths = request.getServletContext().getResourcePaths("/");
            // servlet获取的资源不能是classes路径的内容!!!,只能是webapp下静态资源!!!
            InputStream in = request.getServletContext().getResourceAsStream("/templates/test1.html");
            if (in == null) {
                System.out.println("获取不到资源文件！！！");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
