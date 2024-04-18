package br.dev.hygino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.dto.PersonDTO;
import br.dev.hygino.dto.PersonInsertDTO;
import br.dev.hygino.entities.Person;
import br.dev.hygino.services.PersonService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<Page<PersonDTO>> findAll(Pageable pageable) {
        Page<PersonDTO> page = personService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> inserir(@RequestBody PersonInsertDTO dto) {
        return ResponseEntity.status(201).body(personService.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> atualizar(@PathVariable Long id, @RequestBody PersonInsertDTO dto) {
        return ResponseEntity.status(200).body(personService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(personService.buscarPorId(id));
    }
}
