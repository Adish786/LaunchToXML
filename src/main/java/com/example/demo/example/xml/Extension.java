package com.example.demo.example.xml;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Extension {
    @JsonProperty("patterns")
    private List<Pattern> patterns;

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<Pattern> patterns) {
        this.patterns = patterns;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "patterns=" + patterns +
                '}';
    }

    public Extension(List<Pattern> patterns) {
        this.patterns = patterns;
    }
    public Extension(){}
}
