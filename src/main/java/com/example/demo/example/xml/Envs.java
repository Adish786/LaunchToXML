package com.example.demo.example.xml;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Envs {
    @JsonProperty("env")
    private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "Envs{" +
                "env='" + env + '\'' +
                '}';
    }

    public Envs(String env) {
        this.env = env;
    }
    public Envs(){

    }

}
