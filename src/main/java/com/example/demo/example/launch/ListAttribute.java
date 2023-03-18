package com.example.demo.example.launch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListAttribute {
    @JsonProperty("listEntry")
    private String listEntry;
    private String listAttribute;

    public String getListAttribute() {
        return listAttribute;
    }

    public void setListAttribute(String listAttribute) {
        this.listAttribute = listAttribute;
    }

    public String getListEntry() {
        return listEntry;
    }

    public void setListEntry(String listEntry) {
        this.listEntry = listEntry;
    }


    @Override
    public String toString() {
        return "ListAttribute{" +
                "listEntry='" + listEntry + '\'' +
                '}';
    }

    public ListAttribute(String listEntry) {
        this.listEntry = listEntry;
    }
    public ListAttribute(){}

}
