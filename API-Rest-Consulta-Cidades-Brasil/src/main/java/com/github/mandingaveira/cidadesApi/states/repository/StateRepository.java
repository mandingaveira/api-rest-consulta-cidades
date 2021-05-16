package com.github.mandingaveira.cidadesApi.states.repository;

import com.github.mandingaveira.cidadesApi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

}
