package com.geekluxun.jdk.network;

import org.omg.CORBA.ULongLongSeqHelper;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author: luxun
 * @Create: 2018-07-03 21:53
 * @Description:
 * @Other:
 */
public class URLURIDemo {

    public static void main(String[] argc){
        URLURIDemo demo = new URLURIDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1(){
        try {
            String url = URLEncoder.encode("luxun@@##", "utf-8");
            System.out.println(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void demo2(){
        try {
            URL url = new URL("http://luxun");
            System.out.println(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
