package com.example.demo.entity;

public class Launch {
    private int id;
    private String launchConfiguration;
    private String listAttribute;
    private String listEntry;
    private String mapAttribute;
    private String mapEntry;
    private String booleanAttribute;
    private String stringAttribute;

    @Override
    public String toString() {
        return "Launch{" +
                "id=" + id +
                ", launchConfiguration='" + launchConfiguration + '\'' +
                ", listAttribute='" + listAttribute + '\'' +
                ", listEntry='" + listEntry + '\'' +
                ", mapAttribute='" + mapAttribute + '\'' +
                ", mapEntry='" + mapEntry + '\'' +
                ", booleanAttribute='" + booleanAttribute + '\'' +
                ", stringAttribute='" + stringAttribute + '\'' +
                '}';
    }

    public String getStringAttribute() {
        return stringAttribute;
    }

    public void setStringAttribute(String stringAttribute) {
        this.stringAttribute = stringAttribute;
    }

    public int getId() {
        return id;
    }

    public String getLaunchConfiguration() {
        return launchConfiguration;
    }

    public String getListAttribute() {
        return listAttribute;
    }

    public String getListEntry() {
        return listEntry;
    }

    public String getMapAttribute() {
        return mapAttribute;
    }

    public String getMapEntry() {
        return mapEntry;
    }

    public String getBooleanAttribute() {
        return booleanAttribute;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLaunchConfiguration(String launchConfiguration) {
        this.launchConfiguration = launchConfiguration;
    }

    public void setListAttribute(String listAttribute) {
        this.listAttribute = listAttribute;
    }

    public void setListEntry(String listEntry) {
        this.listEntry = listEntry;
    }

    public void setMapAttribute(String mapAttribute) {
        this.mapAttribute = mapAttribute;
    }

    public void setMapEntry(String mapEntry) {
        this.mapEntry = mapEntry;
    }

    public void setBooleanAttribute(String booleanAttribute) {
        this.booleanAttribute = booleanAttribute;
    }


}
