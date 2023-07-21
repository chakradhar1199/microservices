package com.chakri.microservices.webservices.Filters;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class SomeBean {
    String value1;
    String value2;

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public SomeBean(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}
