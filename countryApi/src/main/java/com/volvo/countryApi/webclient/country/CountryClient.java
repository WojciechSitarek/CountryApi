package com.volvo.countryApi.webclient.country;

import com.volvo.countryApi.webclient.country.dto.RestCountryDto;
import com.volvo.countryApi.model.CountryDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CountryClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String COUNTRY_URL = "https://restcountries.com/v3.1/";
    public CountryDto getCountryByCode(String code) {
        List<RestCountryDto> restCountryDtos = getMethodAsList("alpha/{code}", RestCountryDto[].class, code);

        if (restCountryDtos.isEmpty()) {
            throw new RuntimeException("No country data found for code: " + code);
        }

        RestCountryDto restCountryDto = restCountryDtos.get(0);

        List<String> currencyCodes = new ArrayList<>(restCountryDto.getCurrencies().keySet());
        List<String> languageCodes = new ArrayList<>(restCountryDto.getLanguages().keySet());

        return CountryDto.builder()
                .commonName(restCountryDto.getName().getCommon())
                .officialName(restCountryDto.getName().getOfficial())
                .currencies(currencyCodes)
                .capital(restCountryDto.getCapital())
                .region(restCountryDto.getRegion())
                .subregion(restCountryDto.getSubregion())
                .languages(languageCodes)
                .population(restCountryDto.getPopulation())
                .borders(restCountryDto.getBorders())
                .timezones(restCountryDto.getTimezones())
                .build();
    }


    private <T> List<T> getMethodAsList(String url, Class<T[]> responseType, Object... objects) {
        T[] responseArray = restTemplate.getForObject(COUNTRY_URL + url, responseType, objects);
        return Arrays.asList(responseArray);
    }

}
