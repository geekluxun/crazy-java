package com.geekluxun.component.xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright,2019-2020,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019/10/20 2:05 下午
 * @Description:
 * @Other:
 */
public class Dom4jUtil {
    public static void main(String[] argc) throws Exception {
        parseDocument();
    }

    public static void parseDocument()  throws Exception{
        System.out.println("工作目录:" + System.getProperty("user.dir"));
        File file = null;
        try {
            URL url = Dom4jUtil.class.getClassLoader().getResource("pom.xml");
            file = new File(url.toURI());
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element element = document.getRootElement();
        System.out.println("根:" + element.getName());
        for (Iterator<Element> it = element.elementIterator(); it.hasNext(); ) {
            Element element2 = it.next();
            System.out.println("元素名:" + element2.getName());
            if (element2.getName().equals("dependencies")){
                for (Iterator<Element> it2 = element2.elementIterator(); it2.hasNext(); ){
                    Element e = it2.next();
                    System.out.println("元素名2:" + e.getName());

                }
            }
            // do something
        }

        //Element e22 = document.selectSingleNode("/project/dependencies");

        Element element1 =  (Element) document.selectSingleNode("/project/dependencies");
        List<Node> listNodes2 = null;
        List<Node> con = element1.content();
        Element newDep = DocumentHelper.createElement("dependency");

        //element1.setContent(con);

        Element ee = DocumentHelper.createElement("groupId");
        ee.setText("123");

        newDep.add(ee);

        Element ee2 = DocumentHelper.createElement("artifactId");
        ee2.setText("455");
        newDep.setContent(Arrays.asList(ee,ee2));
        //newDep.add(ee2);


        con.add(newDep);

        element1.setContent(con);

//        System.out.println(listNodes);
//        for (Node node : listNodes){
//            String groupId = node.selectNodes("groupId").get(0).getText();
//            String artifactId = node.selectNodes("artifactId").get(0).getText();
//            if (groupId.equals("com.alibaba") && artifactId.equals("druid")){
//                System.out.println("druid 版本号:" + node.selectNodes("version").get(0).getText());
//                String path = node.getPath();
//                System.out.println("dd");
//                node.detach();
//                //document.remove(node);
//                listNodes2 = document.selectNodes("/project/dependencies/*");
//                System.out.println("dd");
//
//            }
//        }



        //listNodes.add(school);


        //listNodes2 = document.selectNodes("/project/dependencies/*");

        String path = document.getPath();
        String filename = path + document.getName();
        XMLWriter writer = new XMLWriter(new FileWriter(file), OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();

        // lets write to a file
//        try (FileWriter fileWiter = new FileWriter(file)) {
//            XMLWriter writer = new XMLWriter(fileWiter);
//            writer.write( document );
//            writer.close();
//        }

    }
}
