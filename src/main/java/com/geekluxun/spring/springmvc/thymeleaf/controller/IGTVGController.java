package com.geekluxun.spring.springmvc.thymeleaf.controller;

import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-31 9:54
 * @Description:
 * @Other:
 */
public interface IGTVGController {
    /**
     * 模板处理
     * @param request
     * @param response
     * @param servletContext
     * @param templateEngine
     */
    void process(
            HttpServletRequest request, HttpServletResponse response,
            ServletContext servletContext, TemplateEngine templateEngine);

    void process2(
            HttpServletRequest request, HttpServletResponse response,
            ServletContext servletContext, TemplateEngine templateEngine);
}
