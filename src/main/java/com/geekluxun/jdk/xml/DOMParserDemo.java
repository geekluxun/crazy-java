package com.geekluxun.jdk.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 17:07
 * @Description: DOM解析示例
 * @Other:
 */
public class DOMParserDemo {
    static DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    public static void main(String[] args) {
        DOMParserDemo demo = new DOMParserDemo();
        demo.demo1();
    }

    private void demo1() {
        Document document = null;
        document = parse("books.xml");
        //get root element 
        Element rootElement = document.getDocumentElement();
        //traverse child elements 
        NodeList nodes = rootElement.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                System.out.println("element:" + child.getNodeName());
            }
        }

        NodeList nodeList = rootElement.getElementsByTagName("book");
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String id = element.getAttribute("id");
            }
        }
    }

    /**
     * Load and parse XML file into DOM
     *
     * @param filePath
     * @return
     */
    public static Document parse(String filePath) {
        Document document = null;
        try {
            //DOM parser instance 
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            //parse an XML file into a DOM tree
            // 注意此处的路径是相对路径 是"xml/books.xml"不能是"/xml/books.xml"!!!
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("xml/books.xml");
            document = builder.parse(inputStream);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}
