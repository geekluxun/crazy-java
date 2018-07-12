package com.geekluxun.component.sevlet;

import org.checkerframework.checker.units.qual.K;
import org.springframework.stereotype.Service;

import javax.servlet.DispatcherType;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-12 11:25
 * @Description:
 * @Other:
 */
@Service
public class HttpSevletDemo {
    public static void main(String[] argc){
        
    }
    
    public void demo1(HttpServletRequest request){
        try {
            Enumeration<String> h = request.getHeaderNames();
            Enumeration<String> a = request.getAttributeNames();
            HttpSession session = request.getSession();
            Cookie[] cookies = request.getCookies();
            DispatcherType dispatcherType = request.getDispatcherType();
            
            System.out.println("ContentType:" + request.getContentType());
            System.out.println("ServletPath:" +request.getServletPath());
            System.out.println("ContextPath:" + request.getContextPath());
            System.out.println("AuthType:" + request.getAuthType());
            System.out.println("Method:" + request.getMethod());
            // 不存在的话会抛异常
            // Part part = request.getPart("dd");
            // Collection<Part> partList = request.getParts();
            System.out.println("RemoteUser:" + request.getRemoteUser());
            System.out.println("ContentLength:" + request.getContentLength());
            System.out.println("CharacterEncoding:" + request.getCharacterEncoding());
            System.out.println("RequestURI:" + request.getRequestURI());
            System.out.println("RequestURL:" + request.getRequestURL());
            System.out.println("QueryString:" + request.getQueryString());
            System.out.println("Protocol:" + request.getProtocol());
            System.out.println("LocalName:" + request.getLocalName());
            System.out.println("LocalPort:" + request.getLocalPort());
            System.out.println("LocalAddr:" + request.getLocalAddr());
            System.out.println("RemoteUser:" + request.getRemoteUser());
            System.out.println("RemoteAddr:" + request.getRemoteAddr());
            System.out.println("RemoteUser:" + request.getRemoteUser());
            System.out.println("RemotePort:" + request.getRemotePort());
            System.out.println("RemoteHost:" + request.getRemoteHost());
            System.out.println("ServerName:" + request.getServerName());
            System.out.println("ServerPort:" + request.getServerPort());

         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void  demo2(HttpServletRequest request){
       
        try {
            // 实测两种得到的值一样
            Enumeration<String> encodeing1 = request.getHeaders("Accept-Encoding");
            String encodeing2  = request.getHeader("Accept-Encoding");
            while (encodeing1.hasMoreElements()){
                String value = encodeing1.nextElement();
                System.out.println("value:" + value);
            }
            
            // 获取body
            ServletInputStream inputStream = request.getInputStream();
            int value = inputStream.read();
            System.out.println();
            // 获取请求参数
            Map para = request.getParameterMap();
            Set<Map.Entry<K, String>> entries =  para.entrySet();
            for (Map.Entry map :entries){
                System.out.println("key:" + map.getKey() + " value:" + map.getValue());
            }
            // entries.forEach((a)->System.out.println("key:" + a.getKey() + " value:" + a.getValue()));
            
            // 获取当前sevlet容器路径（例如tomcat在系统中的路径 可以用来获取war包中的资源路径）
            String path = request.getServletContext().getRealPath("/dd");
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
