package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoenScannerApplication extends Application<Object> {

    @Override
    public void run(Object configuration, Environment environment) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<SearchResult> searchResults = new ArrayList<>();

        InputStream rentalCars = getClass()
                .getClassLoader()
                .getResourceAsStream("rental_cars.json");

        InputStream hotels = getClass()
                .getClassLoader()
                .getResourceAsStream("hotels.json");

        searchResults.addAll(Arrays.asList(
                mapper.readValue(rentalCars, SearchResult[].class)));

        searchResults.addAll(Arrays.asList(
                mapper.readValue(hotels, SearchResult[].class)));

        environment.jersey().register(
                new SearchResource(searchResults));
    }

    public static void main(String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }
}
