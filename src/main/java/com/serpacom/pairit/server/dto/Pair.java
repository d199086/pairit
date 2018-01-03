package com.serpacom.pairit.server.dto;

/**
 * Created by deepakga on 1/2/2018.
 */
public class Pair {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Pair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Pair() {
    }


}
