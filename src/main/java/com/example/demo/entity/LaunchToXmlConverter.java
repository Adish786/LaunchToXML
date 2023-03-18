package com.example.demo.entity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LaunchToXmlConverter {

    public static void main(String[] args) throws Exception {
        // Load the .launch file
        Map<String, String> params = loadLaunchFile("E:\\Microservice Project\\demo\\src\\TestFile.launch");

        // Load the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("E:\\Microservice Project\\demo\\staff-dom.xml"));
        Element root = doc.getDocumentElement();

        // Set the parameter values in the XML file
        for (String key : params.keySet()) {
            NodeList nodes = root.getElementsByTagName(key);
            if (nodes.getLength() > 0) {
                nodes.item(0).setTextContent(params.get(key));
            }
        }

        // Write the updated XML file
        javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(
                new javax.xml.transform.dom.DOMSource(doc),
                new javax.xml.transform.stream.StreamResult(new File("E:\\Microservice Project\\demo\\staff-dom.xml"))
        );
    }

    private static Map<String, String> loadLaunchFile(String launchFilePath) throws Exception {
        Map<String, String> params = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(launchFilePath));
        NodeList nodes = doc.getElementsByTagName("param");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element param = (Element) nodes.item(i);
            String key = param.getAttribute("name");
            String value = param.getAttribute("value");
            params.put(key, value);
        }
        return params;
    }
}
