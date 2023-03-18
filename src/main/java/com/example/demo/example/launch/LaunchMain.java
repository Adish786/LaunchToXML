package com.example.demo.example.launch;
import java.util.List;
public class LaunchMain {
    private String launchConfiguration;
    private List<ListAttribute> listAttribute;
    private List<MapAttribute> mapAttribute;
    private String booleanAttribute;
    private String stringAttribute;
    public LaunchMain() {
    }
    public String getLaunchConfiguration() {
        return launchConfiguration;
    }
    public void setLaunchConfiguration(String launchConfiguration) {
        this.launchConfiguration = launchConfiguration;
    }

    public List<ListAttribute> getListAttribute() {
        return listAttribute;
    }

    public void setListAttribute(List<ListAttribute> listAttribute) {
        this.listAttribute = listAttribute;
    }

    public List<MapAttribute> getMapAttribute() {
        return mapAttribute;
    }

    public void setMapAttribute(List<MapAttribute> mapAttribute) {
        this.mapAttribute = mapAttribute;
    }

    public String getBooleanAttribute() {
        return booleanAttribute;
    }

    public void setBooleanAttribute(String booleanAttribute) {
        this.booleanAttribute = booleanAttribute;
    }

    public String getStringAttribute() {
        return stringAttribute;
    }

    public void setStringAttribute(String stringAttribute) {
        this.stringAttribute = stringAttribute;
    }

    @Override
    public String toString() {
        return "LaunchMain{" +
                "launchConfiguration='" + launchConfiguration + '\'' +
                ", listAttribute=" + listAttribute +
                ", mapAttribute=" + mapAttribute +
                ", booleanAttribute='" + booleanAttribute + '\'' +
                ", stringAttribute='" + stringAttribute + '\'' +
                '}';
    }

    public LaunchMain(String launchConfiguration, List<ListAttribute> listAttribute, List<MapAttribute> mapAttribute, String booleanAttribute, String stringAttribute) {
        this.launchConfiguration = launchConfiguration;
        this.listAttribute = listAttribute;
        this.mapAttribute = mapAttribute;
        this.booleanAttribute = booleanAttribute;
        this.stringAttribute = stringAttribute;
    }
}
