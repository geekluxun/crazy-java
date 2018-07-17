package com.geekluxun.apache.commons.digester;

import com.alibaba.fastjson.JSON;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.annotations.FromAnnotationsRuleModule;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 16:37
 * @Description:
 * @Other:
 */
public class DigesterDemo {
    public static final String DEFAULT_CONFIG_LOCATION = "/conf/expinfo-import-validate-rules.xml";

    public static void main(String[] argc) {
        DigesterDemo demo = new DigesterDemo();
        demo.demo1();
    }

    private void demo1() {
        // 加载资源文件
        Resource resource = new ClassPathResource("xml/validator.xml");
        if (resource.exists()) {
            try {
                ExpImpValContext expImpValContext = parseXMLObject(ExpImpValContext.class, resource);
                System.out.println("JSON:" + JSON.toJSONString(expImpValContext));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }

    }

    public static <T> T parseXMLObject(Class<T> clazz, Resource resource) throws IOException, SAXException {
        InputStream is = resource.getInputStream();
        InputSource inputSource = new InputSource(is);

        // 规则是通过注解定义的
        DigesterLoader loader = DigesterLoader.newLoader(new FromAnnotationsRuleModule() {
            @Override
            protected void configureRules() {
                bindRulesFrom(clazz);
            }
        });

        Digester digester = loader.newDigester();
        return (T) digester.parse(inputSource);
    }

}
