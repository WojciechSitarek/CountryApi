package com.volvo.countryApi.mapper;

import com.volvo.countryApi.model.CountryDto;
import com.volvo.countryApi.model.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryEntity toEntity(CountryDto countryDto) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCommonName(countryDto.getCommonName());
        countryEntity.setOfficialName(countryDto.getOfficialName());
        countryEntity.setCurrencies(countryDto.getCurrencies());
        countryEntity.setCapital(countryDto.getCapital());
        countryEntity.setRegion(countryDto.getRegion());
        countryEntity.setSubregion(countryDto.getSubregion());
        countryEntity.setLanguages(countryDto.getLanguages());
        countryEntity.setPopulation(countryDto.getPopulation());
        countryEntity.setBorders(countryDto.getBorders());
        countryEntity.setTimezones(countryDto.getTimezones());
        return countryEntity;
    }

    public CountryDto toDto(CountryEntity countryEntity) {
        return CountryDto.builder()
                .commonName(countryEntity.getCommonName())
                .officialName(countryEntity.getOfficialName())
                .currencies(countryEntity.getCurrencies())
                .capital(countryEntity.getCapital())
                .region(countryEntity.getRegion())
                .subregion(countryEntity.getSubregion())
                .languages(countryEntity.getLanguages())
                .population(countryEntity.getPopulation())
                .borders(countryEntity.getBorders())
                .timezones(countryEntity.getTimezones())
                .build();
    }
}
