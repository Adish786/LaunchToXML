package com.example.demo.example;

import com.example.demo.example.launch.LaunchMain;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;


public class ReaderFile {

    public static void main(String[] args) throws IOException, JDOMException, ParserConfigurationException {
        // String filePath=args[0];
        //File launchFile = new File(filePath);
        File launchFile = new File("E:\\Microservice Project\\demo\\MantleRefMain.launch");
        Document doc = new SAXBuilder().build(launchFile);
        List<Element> stringAttributeNode = doc.getRootElement().getChildren("stringAttribute");
        String fullyQualifiedMainClassName = getFullQualifiedMainClass(stringAttributeNode);
        String mainClassName = getMainClassName(fullyQualifiedMainClassName);
        Element provider = doc.getRootElement().getChild("stringAttribute");
        String stringProvider = getStringProvider(provider);
        List<Element> attribute = doc.getRootElement().getChildren("stringAttribute");
        String attributes = getAttribute(attribute);
        Element environmentVariables = doc.getRootElement().getChild("mapAttribute");
        String env = environmentVariables.getAttribute("key").getValue();
        List<Element> attributeString = doc.getRootElement().getChildren("stringAttribute");
        String att = getAttributeString(attributeString);
        List<Element> elements = doc.getRootElement().getChildren("stringAttribute");
        String element = getElementString(elements);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        org.w3c.dom.Document newDoc = docBuilder.newDocument();
        org.w3c.dom.Element rootElement = newDoc.createElement("component");
        rootElement.setAttribute("name", "ProjectRunConfigurationManager");
        newDoc.appendChild(rootElement);
        org.w3c.dom.Element configuration = newDoc.createElement("configuration");
        configuration.setAttribute("default", "false");
        configuration.setAttribute("name", mainClassName);
        configuration.setAttribute("type", "Application");
        configuration.setAttribute("factoryName", "Application");
        configuration.setAttribute("nameIsGenerated", "true");
        rootElement.appendChild(configuration);
        org.w3c.dom.Element envs = newDoc.createElement("envs");
        org.w3c.dom.Element envsenv = newDoc.createElement("env");
        envsenv.setAttribute("name", "AWS_PROFILE");
        envsenv.setAttribute("value", "about-dev");
        org.w3c.dom.Element envEnvName = newDoc.createElement("env");
        envEnvName.setAttribute("name", "AWS_REGION");
        envEnvName.setAttribute("value", "us-east-1");
        envs.appendChild(envsenv);
        envs.appendChild(envEnvName);
        configuration.appendChild(envs);
        org.w3c.dom.Element option = newDoc.createElement("option");
        option.setAttribute("name", "MAIN_CLASS_NAME");
        option.setAttribute("value", fullyQualifiedMainClassName);
        configuration.appendChild(option);
        org.w3c.dom.Element module = newDoc.createElement("module");
        module.setAttribute("name", att);
        configuration.appendChild(module);
        org.w3c.dom.Element optionPara = newDoc.createElement("option");
        optionPara.setAttribute("name", "VM_PARAMETERS");
        optionPara.setAttribute("value", attributes);
        configuration.appendChild(optionPara);
        org.w3c.dom.Element optionWorking = newDoc.createElement("option");
        optionWorking.setAttribute("name", "WORKING_DIRECTORY");
        optionWorking.setAttribute("value", "$MODULE_WORKING_DIR$");
        configuration.appendChild(optionWorking);
        org.w3c.dom.Element extension = newDoc.createElement("extension");
        extension.setAttribute("name", "coverage");
        configuration.appendChild(extension);
        org.w3c.dom.Element pattern = newDoc.createElement("pattern");
        extension.appendChild(pattern);
        org.w3c.dom.Element optionPatter = newDoc.createElement("option");
        optionPatter.setAttribute("name", "PATTERN");
        optionPatter.setAttribute("value", element);
        pattern.appendChild(optionPatter);
        org.w3c.dom.Element optionEnable = newDoc.createElement("option");
        optionEnable.setAttribute("name", "ENABLED");
        optionEnable.setAttribute("value", "true");
        pattern.appendChild(optionEnable);
        org.w3c.dom.Element method = newDoc.createElement("method");
        method.setAttribute("v", "2");
        configuration.appendChild(method);
        org.w3c.dom.Element methodOption = newDoc.createElement("option");
        methodOption.setAttribute("enabled", "true");
        methodOption.setAttribute("name", "Make");
        method.appendChild(methodOption);
        String outputFileName = mainClassName + "-run.xml";
        try (FileOutputStream output = new FileOutputStream(outputFileName)) {
            writeXml(newDoc, output);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static String getFullQualifiedMainClass(List<Element> stringAttributeNode) {
        String fullyQualifiedMainClassName = null;
        for (int i = 0; i < stringAttributeNode.size(); i++) {
            if (stringAttributeNode.get(i).getAttribute("key").getValue().equals("org.eclipse.jdt.launching.MAIN_TYPE")) {
                fullyQualifiedMainClassName = stringAttributeNode.get(i).getAttribute("value").getValue();
            }
        }
        return fullyQualifiedMainClassName;
    }

    private static String getMainClassName(String fullQualifiedClassName) {
        String mainClassName = null;
        String[] split = fullQualifiedClassName.split("\\.");
        mainClassName = split[split.length - 1];
        return mainClassName;
    }

    private static String getAttribute(List<Element> attribute) {
        String attributes = null;
        for (int i = 0; i < attribute.size(); i++) {
            if (attribute.get(i).getAttribute("key").getValue().equals("org.eclipse.jdt.launching.VM_ARGUMENTS")) {
                attributes = attribute.get(i).getAttribute("value").getValue();
            }
        }
        return attributes;
    }

    private static String getAttributeString(List<Element> attributeString) {
        String att = null;
        for (int i = 0; i < attributeString.size(); i++) {
            if (attributeString.get(i).getAttribute("key").getValue().equals("org.eclipse.jdt.launching.PROJECT_ATTR")) {
                att = attributeString.get(i).getAttribute("value").getValue();
            }
        }
        return att;
    }

    private static String getElementString(List<Element> elements) {
        String element = null;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getAttribute("key").getValue().equals("org.eclipse.jdt.launching.MAIN_TYPE")) {
                String tech1 = elements.get(i).getAttribute("value").getValue();
                String[] word = tech1.split("\\.");
                int lastWordIndex = word.length - 1;
                word[lastWordIndex] = "*";
                element = String.join(".", word);
            }
        }
        return element;
    }

    private static String getStringProvider(Element provider) {
        String stringProvider = null;
        if (provider.getAttribute("key").getValue().equals("org.eclipse.jdt.launching.CLASSPATH_PROVIDER")) {
            String pathV = provider.getAttribute("value").getValue();
            String[] split = pathV.split("\\.");
            stringProvider = split[split.length - 1];
        }
        return stringProvider;
    }

    private static void writeXml(org.w3c.dom.Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }
}

