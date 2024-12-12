package com.volvo.countryApi.webclient.country.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RestCountryDto {
    private Name name;
    private Map<String, Currency> currencies;
    private List<String> capital;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private int population;
    private List<String> borders;
    private List<String> timezones;

    @Data
    public static class Name {
        private String common;
        private String official;
    }

    @Data
    public static class Currency {
        private String name;
        private String symbol;
    }
}