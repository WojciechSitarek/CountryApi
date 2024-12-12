package com.volvo.countryApi.controller;

import com.volvo.countryApi.model.CountryDto;
import com.volvo.countryApi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CountryController {

    private final CountryService countryService;
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country/{code}")
    public CountryDto getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }
}
