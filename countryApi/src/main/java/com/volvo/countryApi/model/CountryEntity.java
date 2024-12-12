package com.volvo.countryApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Countries")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commonName;
    private String officialName;
    private String region;
    private String subregion;
    private int population;
    private List<String> currencies;
    private List<String> capital;
    private List<String> languages;
    private List<String> borders;
    private List<String> timezones;
}
