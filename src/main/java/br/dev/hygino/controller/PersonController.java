package br.dev.hygino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.entities.Person;
import br.dev.hygino.services.PersonService;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public ResponseEntity<Page<Person>> findAll(Pageable pageable) {
        Page<Person> page = personService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

}
