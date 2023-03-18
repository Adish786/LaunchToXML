package com.example.demo.entity;

public class MantleRef {
    private String component;
    private String configuration;
    private String envs;
    private String env;
    private String option;
    private String module;
    private String extension;
    private String pattern;
    private String method;

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

    public String getEnvs() {
        return envs;
    }

    public void setEnvs(String envs) {
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "MantleRef{" +
                "component='" + component + '\'' +
                ", configuration='" + configuration + '\'' +
                ", envs='" + envs + '\'' +
                ", env='" + env + '\'' +
                ", option='" + option + '\'' +
                ", module='" + module + '\'' +
                ", extension='" + extension + '\'' +
                ", pattern='" + pattern + '\'' +
                ", method='" + method + '\'' +
                '}';
    }


}
