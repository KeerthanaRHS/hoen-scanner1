package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {

    @JsonProperty
    private String city;

    public Search() {}

    public String getCity() {
        return city;
    }
}
