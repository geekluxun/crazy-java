package com.geekluxun.apache.commons.configure;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.Collection;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 15:44
 * @Description:
 * @Other:
 */
public class XMLConfigurationDemo {
    public static void main(String[] argc) {
        XMLConfigurationDemo demo = new XMLConfigurationDemo();
        demo.demo1();
        demo.demo2();
    }


    /**
     * xml 主要由以下几部分组成
     * Tag， Element， Attribute 结构如下：<tag atrribute="value">element</tag>
     */
    private void demo1() {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<XMLConfiguration> builder =
                new FileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
                        .configure(params.xml()
                                .setFileName("xml/gui.xml"));
        try {
            XMLConfiguration config = builder.getConfiguration();

            String backColor = config.getString("colors.background");
            String textColor = config.getString("colors.text");
            String linkNormal = config.getString("colors.link[@normal]");
            // 使用了站位符
            String defColor = config.getString("colors.default");
            int rowsPerPage = config.getInt("rowsPerPage");
            // 是一个list
            List<Object> buttons = config.getList("buttons.name");
            System.out.println();
        } catch (ConfigurationException e) {
            System.out.println(e);
        }
    }

    private void demo2() {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<XMLConfiguration> builder =
                new FileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
                        .configure(params.xml()
                                .setFileName("xml/database.xml"));
        try {
            XMLConfiguration config = builder.getConfiguration();

            Object prop = config.getProperty("tables.table.name");
            if (prop instanceof Collection) {
                System.out.println("Number of tables: " + ((Collection<?>) prop).size());
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}