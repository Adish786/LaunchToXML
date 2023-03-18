package com.example.demo.example.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class XmlMain {
    @JsonProperty("component")
    private String component;
    @JsonProperty("configuration")
    private String configuration;
    @JsonProperty("envs")
    private List<Envs> envs;
    @JsonProperty("env")
    private String env;
    @JsonProperty("option")
    private String option;
    @JsonProperty("module")
    private String module;
    @JsonProperty("extension")
    private List<Extension> extension;
    @JsonProperty("patterns")
    private List<Pattern> pattern;
    @JsonProperty("method")
    private List<Method> method;

    public XmlMain() {

    }


    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public List<Envs> getEnvs() {
        return envs;
    }

    public void setEnvs(List<Envs> envs) {
        this.envs = envs;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<Extension> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension> extension) {
        this.extension = extension;
    }

    public List<Pattern> getPattern() {
        return pattern;
    }

    public void setPattern(List<Pattern> pattern) {
        this.pattern = pattern;
    }

    public List<Method> getMethod() {
        return method;
    }

    public void setMethod(List<Method> method) {
        this.method = method;
    }


    @Override
    public String toString() {
        return "XmlMain{" +
                "component='" + component + '\'' +
                ", configuration='" + configuration + '\'' +
                ", envs=" + envs +
                ", env='" + env + '\'' +
                ", option='" + option + '\'' +
                ", module='" + module + '\'' +
                ", extension=" + extension +
                ", pattern=" + pattern +
                ", method=" + method +
                '}';
    }

    public XmlMain(String component, String configuration, List<Envs> envs, String env, String option, String module, List<Extension> extension, List<Pattern> pattern, List<Method> method) {
        this.component = component;
        this.configuration = configuration;
        this.envs = envs;
        this.env = env;
        this.option = option;
        this.module = module;
        this.extension = extension;
        this.pattern = pattern;
        this.method = method;
    }
}
