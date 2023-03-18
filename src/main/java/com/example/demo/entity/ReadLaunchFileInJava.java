package com.example.demo.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ReadLaunchFileInJava {
    public static void main(String[] args) {
        String filePath = "../src/TestFile.launch";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Launch");
            List<Launch> launchList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                launchList.add(getLaunch(nodeList.item(i)));
            }
            for (Launch emp : launchList) {
                System.out.println(emp.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static Launch getLaunch(Node node) {
        Launch launch = new Launch();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            launch.setId(Integer.parseInt(getTagValue("id", element)));
            launch.setLaunchConfiguration(getTagValue("launchConfiguration", element));
            launch.setListAttribute(getTagValue("listAttribute", element));
            launch.setListEntry(getTagValue("listEntry", element));
            launch.setMapAttribute(getTagValue("mapAttribute", element));
            launch.setMapEntry(getTagValue("mapEntry", element));
            launch.setBooleanAttribute(getTagValue("booleanAttribute", element));
        }
        return launch;
    }
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
