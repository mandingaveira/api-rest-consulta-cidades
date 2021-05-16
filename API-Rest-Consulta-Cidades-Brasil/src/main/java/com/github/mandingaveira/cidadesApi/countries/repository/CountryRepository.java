package com.github.mandingaveira.cidadesApi.countries.repository;

import com.github.mandingaveira.cidadesApi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
