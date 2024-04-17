package br.dev.hygino.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.dev.hygino.entities.Person;
import br.dev.hygino.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
