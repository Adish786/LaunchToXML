package com.example.demo.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMantleRefFileJava {
    public static void main(String[] args) {
        String filePath = "./MantleRefMain.run.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("MantleRef");
            List<MantleRef> mantleRefs = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                mantleRefs.add(getMantleRef(nodeList.item(i)));
            }
            for (MantleRef emp : mantleRefs) {
                System.out.println(emp.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static MantleRef getMantleRef(Node node) {
        MantleRef mantleRef = new MantleRef();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            mantleRef.setComponent(getTagValue("component", element));
            mantleRef.setConfiguration(getTagValue("configuration", element));
            mantleRef.setEnvs(getTagValue("envs", element));
            mantleRef.setEnv(getTagValue("env", element));
            mantleRef.setExtension(getTagValue("extension", element));
            mantleRef.setModule(getTagValue("module", element));
            mantleRef.setMethod(getTagValue("method",element));
            mantleRef.setOption(getTagValue("option",element));
            mantleRef.setPattern(getTagValue("pattern",element));
        }
        return mantleRef;
    }
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
