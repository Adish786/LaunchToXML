package com.example.demo.example.launch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapAttribute {
    @JsonProperty("mapEntry")
    private String mapEntry;
    private String mapAttribute;

    public String getMapAttribute() {
        return mapAttribute;
    }

    public void setMapAttribute(String mapAttribute) {
        this.mapAttribute = mapAttribute;
    }

    public String getMapEntry() {
        return mapEntry;
    }

    public void setMapEntry(String mapEntry) {
        this.mapEntry = mapEntry;
    }

    @Override
    public String toString() {
        return "MapAttribute{" +
                "mapEntry='" + mapEntry + '\'' +
                '}';
    }

    public MapAttribute(String mapEntry) {
        this.mapEntry = mapEntry;
    }
    public MapAttribute(){}
}
