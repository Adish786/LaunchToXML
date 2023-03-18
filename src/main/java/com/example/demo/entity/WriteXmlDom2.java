package com.example.demo.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
//TODO: add attributes to the configuration tah
//TODO: add name="VM_PARAMETERS" attribute to the option tag
//TODO: product an output file with name {input-file-name}-intellij-runc.xml
//TODO: mantleRefMain string is hardcoded, this needs to be fetched from the corresponding eclipse .launch file
public class WriteXmlDom2 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        String filePath = "./TechJettyApp.launch";
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
        Element rootElement = doc.createElement("component");
        rootElement.setAttribute("name", "ProjectRunConfigurationManager");
        doc.appendChild(rootElement);
        Element configuration = doc.createElement("configuration");
        configuration.setAttribute("default", "false");
        configuration.setAttribute("name", "MantleRefMain");
        //TODO: This needs to be read dynamically from the .launch file
        //TODO: Check the sample input and output
        //TODO: Check your code on TechJettyApp.launch and MantleRefMain.launch
        configuration.setAttribute("type", "Application");
        configuration.setAttribute("factoryName", "Application");
        configuration.setAttribute("nameIsGenerated", "true");
        rootElement.appendChild(configuration);
        Element envs = doc.createElement("envs");
        Element env1 = doc.createElement("env");
        env1.setAttribute("name", "AWS_PROFILE ");
        env1.setAttribute("value", "about-dev");
        Element env2 = doc.createElement("env");
        env2.setAttribute("name", "AWS_REGION");
        env2.setAttribute("value", "us-east-1");
        envs.appendChild(env1);
        envs.appendChild(env2);
        configuration.appendChild(envs);
        Element option = doc.createElement("option");
        option.setAttribute("name", "MAIN_CLASS_NAME");
        option.setAttribute("value", "com.about.mantle.reference.MantleRefMain");
        configuration.appendChild(option);
        Element module = doc.createElement("module");
        module.setAttribute("name", "mantle-ref.mantle-ref-launcher.main");
        configuration.appendChild(module);
        Element option2 = doc.createElement("option");
        option2.setAttribute("name", "VM_PARAMETERS");
        option2.setAttribute("value", "-server -Xmx1024m -Dconsul.enabled=true -Dconsul.url=https://consul-qa.a-ue1.dotdash.com:8500 -Dconsul.token=dev -Dcom.sun.management.jmxremote -Denvironment=k8s-stable -Dapplication=mantle-ref -Dservername=localhost");
        configuration.appendChild(option2);
        Element option3 = doc.createElement("option");
        option3.setAttribute("name", "WORKING_DIRECTORY");
        option3.setAttribute("value", "$MODULE_WORKING_DIR$");
        configuration.appendChild(option3);
        Element extension = doc.createElement("extension");
        extension.setAttribute("name", "coverage");
        configuration.appendChild(extension);
        Element pattern = doc.createElement("pattern");
        extension.appendChild(pattern);
        Element option4 = doc.createElement("option");
        option4.setAttribute("name", "PATTERN");
        option4.setAttribute("value", "com.about.mantle.reference.*");
        pattern.appendChild(option4);
        Element option5 = doc.createElement("option");
        option5.setAttribute("name", "ENABLED");
        option5.setAttribute("value", "true");
        pattern.appendChild(option5);
        Element method = doc.createElement("method");
        method.setAttribute("v", "2");
        configuration.appendChild(method);
        Element option6 = doc.createElement("option");
        option6.setAttribute("name", "Make");
        option6.setAttribute("enabled", "true");
        method.appendChild(option6);
        try (FileOutputStream output = new FileOutputStream("./test-dom.xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Launch getLaunch(Node node) {
        Launch launch = new Launch();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            launch.setLaunchConfiguration(getTagValue("launchConfiguration", element));
            launch.setListAttribute(getTagValue("listAttribute", element));
            launch.setListEntry(getTagValue("listEntry", element));
            launch.setMapAttribute(getTagValue("mapAttribute", element));
            launch.setMapEntry(getTagValue("mapEntry", element));
            launch.setBooleanAttribute(getTagValue("booleanAttribute", element));
            launch.setStringAttribute(getTagValue("stringAttribute", element));
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
