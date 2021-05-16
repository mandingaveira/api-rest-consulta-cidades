package com.github.mandingaveira.cidadesApi.countries.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundExceptions extends Exception{

    public CountryNotFoundExceptions(Long id) {
        super("Country not found with id " + id);
    }
}
