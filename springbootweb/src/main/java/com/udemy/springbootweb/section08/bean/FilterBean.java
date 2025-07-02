package com.udemy.springbootweb.section08.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Static Filter
@JsonIgnoreProperties({"property2"})
@JsonFilter("ResponseFilter")
public class FilterBean {

    // Static Filter
    @JsonIgnore
    private String property1;
    private String property2;
    private String property3;
    private String property4;
    @JsonProperty("first_name")
    private String property5;
    @JsonProperty("last_name")
    private String property6;

    public FilterBean(String property1, String property2, String property3, String property4, String property5, String property6) {
        this.property1 = property1;
        this.property2 = property2;
        this.property3 = property3;
        this.property4 = property4;
        this.property5 = property5;
        this.property6 = property6;
    }

    public String getProperty1() {
        return property1;
    }

    public String getProperty2() {
        return property2;
    }

    public String getProperty3() {
        return property3;
    }

    public String getProperty4() {
        return property4;
    }

    public String getProperty5() {
        return property5;
    }

    public String getProperty6() {
        return property6;
    }

    @Override
    public String toString() {
        return "FilterBean{" +
                "property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                ", property3='" + property3 + '\'' +
                ", property4='" + property4 + '\'' +
                ", property5='" + property5 + '\'' +
                ", property6='" + property6 + '\'' +
                '}';
    }
}
