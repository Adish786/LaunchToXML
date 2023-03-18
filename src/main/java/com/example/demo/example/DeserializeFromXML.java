package com.example.demo.example;

import com.example.demo.example.xml.XmlMain;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeserializeFromXML {
    public static void main(String[] args) throws IOException {
        System.out.println("Deserializing from XML...");
        deserializeFromXML();
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

    /*
    public static void deserializeFromXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String readContent = new String(Files.readAllBytes(Paths.get("E:\\Microservice Project\\demo\\MantleRefMain-run.xml")));
            LaunchMain deserializedData = xmlMapper.readValue(readContent, LaunchMain.class);
            System.out.println("Deserialized data: ");
            System.out.println("\tLaunchConfig: " + deserializedData.getLaunchConfiguration());
            System.out.println("\tStringAttribute: " + deserializedData.getStringAttribute());
            System.out.println("\tListAttribute " + deserializedData.getListAttribute());
        } catch (IOException e) {
        }
    }
     */
}
