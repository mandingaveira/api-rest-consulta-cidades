package com.github.mandingaveira.cidadesApi.states.resource;


import com.github.mandingaveira.cidadesApi.states.entities.State;
import com.github.mandingaveira.cidadesApi.states.repository.StateRepository;
import com.github.mandingaveira.cidadesApi.states.exceptions.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateResource {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public Page<State> states(Pageable page){
        return stateRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public State stateById(@PathVariable Long id) throws StateNotFoundException {
        return verifyByExists(id);
    }

    private State verifyByExists(Long id) throws StateNotFoundException{
        return stateRepository.findById(id).orElseThrow(() -> new StateNotFoundException(id));
    }
}
