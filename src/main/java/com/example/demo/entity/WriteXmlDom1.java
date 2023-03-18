package com.example.demo.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteXmlDom1 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        String filePath = "E:\\Microservice Project\\demo\\src\\TestFile.launch";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("MantleRef");
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
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("launchConfiguration");
        rootElement.setAttribute("type","org.eclipse.jdt.launching.localJavaApplication");
        doc.appendChild(rootElement);
        Element listAttribute = doc.createElement("listAttribute");
        rootElement.appendChild(listAttribute);
        listAttribute.setAttribute("key", "org.eclipse.debug.core.MAPPED_RESOURCE_PATHS");
        Element listEntry = doc.createElement("listEntry");
        listEntry.setAttribute("value","/mantle-ref-launcher/src/main/java/com/about/mantle/reference/MantleRefMain.java");
        listAttribute.appendChild(listEntry);
        Element listAttribute2 = doc.createElement("listAttribute");
        rootElement.appendChild(listAttribute2);
        listAttribute2.setAttribute("key", "org.eclipse.debug.core.MAPPED_RESOURCE_TYPES");
        Element listEntry2 = doc.createElement("listEntry");
        listEntry2.setAttribute("value","1");
        listAttribute2.appendChild(listEntry2);
        Element mapAttribute = doc.createElement("mapAttribute");
        rootElement.appendChild(mapAttribute);
        mapAttribute.setAttribute("key", "org.eclipse.debug.core.environmentVariables");
        Element mapEntry = doc.createElement("mapEntry");
        mapEntry.setAttribute("AWS_PROFILE","about-dev");
        mapAttribute.appendChild(mapEntry);
        Element mapEntry2 = doc.createElement("mapEntry");
        mapEntry2.setAttribute("AWS_REGION","us-east-1");
        mapAttribute.appendChild(mapEntry2);
        Element booleanAttribute = doc.createElement("booleanAttribute");
        booleanAttribute.setAttribute("org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD","true");
        rootElement.appendChild(booleanAttribute);
        Element stringAttribute = doc.createElement("stringAttribute");
        stringAttribute.setAttribute("org.eclipse.jdt.launching.CLASSPATH_PROVIDER","org.eclipse.m2e.launchconfig.classpathProvider");
        rootElement.appendChild(stringAttribute);
        Element stringAttribute2 = doc.createElement("stringAttribute");
        stringAttribute2.setAttribute("org.eclipse.jdt.launching.MAIN_TYPE","com.about.mantle.reference.MantleRefMain");
        rootElement.appendChild(stringAttribute2);
        Element stringAttribute3 = doc.createElement("stringAttribute");
        stringAttribute3.setAttribute("org.eclipse.jdt.launching.PROJECT_ATTR","mantle-ref.mantle-ref-launcher.main");
        rootElement.appendChild(stringAttribute3);
        Element stringAttribute4 = doc.createElement("stringAttribute");
        stringAttribute4.setAttribute("org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER","org.eclipse.m2e.launchconfig.sourcepathProvider");
        rootElement.appendChild(stringAttribute4);
        Element stringAttribute5 = doc.createElement("stringAttribute");
        stringAttribute5.setAttribute("org.eclipse.jdt.launching.VM_ARGUMENTS","-server -Xmx1024m -Dcom.sun.management.jmxremote -Denvironment=k8s-globe-core-dev -Dapplication=mantle-ref -Dconsul.enabled=true -Dconsul.url=https://consul-qa.a-ue1.dotdash.com:8500 -Dconsul.token=dev -Dcia.enabled=false -Dservername=localhost");
        rootElement.appendChild(stringAttribute5);
        try (FileOutputStream output = new FileOutputStream("./staff-dom.xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
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
    private static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }
}