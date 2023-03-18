package com.example.demo.example.xml;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pattern {
    @JsonProperty("option")
    private String option;


    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Method{" +
                "option='" + option + '\'' +
                '}';
    }

    public Pattern(String option) {
        this.option = option;
    }
    public Pattern(){}
}
