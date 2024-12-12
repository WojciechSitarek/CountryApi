package com.volvo.countryApi.service;

import com.volvo.countryApi.mapper.CountryMapper;
import com.volvo.countryApi.model.CountryDto;
import com.volvo.countryApi.model.CountryEntity;
import com.volvo.countryApi.repository.CountryRepository;
import com.volvo.countryApi.webclient.country.CountryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryClient countryClient;
    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    public CountryDto getCountry(String code) {
        CountryEntity countryEntity = countryRepository.findByCommonName(code);

        if (countryEntity == null) {
                CountryDto countryDto = countryClient.getCountryByCode(code);
                countryEntity = countryMapper.toEntity(countryDto);
                countryRepository.save(countryEntity);
        }

        return countryMapper.toDto(countryEntity);

    }
}
