package com.volvo.countryApi.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CountryDto {
    private String commonName;
    private String officialName;
    private List<String> currencies;
    private List<String> capital;
    private String region;
    private String subregion;
    private List<String> languages;
    private int population;
    private List<String> borders;
    private List<String> timezones;
}