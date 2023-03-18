package com.example.demo.example;

import com.example.demo.example.launch.LaunchMain;
import com.example.demo.example.launch.ListAttribute;
import com.example.demo.example.launch.MapAttribute;
import com.example.demo.example.xml.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeToXML {
    public static void main(String[] args) throws IOException, JDOMException {
        LaunchMain launchMain = new LaunchMain();
        launchMain.setLaunchConfiguration("org.eclipse.jdt.launching.localJavaApplication");
        List<ListAttribute> listAttributeList = new ArrayList<>();
        ListAttribute listAttribute = new ListAttribute();
        listAttribute.setListAttribute("org.eclipse.debug.core.MAPPED_RESOURCE_PATHS");
        listAttribute.setListEntry("/mantle-ref-launcher/src/main/java/com/about/mantle/reference/MantleRefMain.java");
        listAttributeList.add(listAttribute);
        launchMain.setListAttribute(listAttributeList);
        List<MapAttribute> mapAttributeList = new ArrayList<>();
        MapAttribute mapAttribute = new MapAttribute();
        mapAttribute.setMapAttribute("org.eclipse.debug.core.environmentVariables");
        mapAttribute.setMapEntry("AWS_PROFILE");
        mapAttribute.setMapEntry("about-dev");
        mapAttribute.setMapEntry("AWS_REGION");
        mapAttribute.setMapEntry("us-east-1");
        mapAttributeList.add(mapAttribute);
        launchMain.setMapAttribute(mapAttributeList);
        launchMain.setBooleanAttribute("org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD");
        launchMain.setStringAttribute("org.eclipse.jdt.launching.CLASSPATH_PROVIDER");
        serializeToXML(launchMain);
    }

    private static void serializeToXML(LaunchMain settings) throws IOException {
        FileOutputStream fos = new FileOutputStream("E:\\Microservice Project\\demo\\MantleRefMain-run.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.writeObject(settings);
        encoder.close();
        fos.close();
    }

    private static XmlMain deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Microservice Project\\demo\\MantleRefMain-run.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        XmlMain decodedSettings = (XmlMain) decoder.readObject();
        System.out.println(decodedSettings);
        decoder.close();
        fis.close();
        return decodedSettings;
    }


    public static void serializeToXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlString = xmlMapper.writeValueAsString(new LaunchMain());
            System.out.println(xmlString);
            File xmlOutput = new File("E:\\Microservice Project\\demo\\MantleRefMain-run.xml");
            FileWriter fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(xmlString);
            fileWriter.close();
        } catch (JsonProcessingException e) {
        } catch (IOException e) {
        }
    }


}
