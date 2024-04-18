package br.dev.hygino.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.dto.PersonDTO;
import br.dev.hygino.dto.PersonInsertDTO;
import br.dev.hygino.entities.Person;
import br.dev.hygino.repositories.PersonRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(readOnly = true)
    public Page<PersonDTO> findAll(Pageable pageable) {
        Page<Person> page = personRepository.findAll(pageable);
        return page.map(x -> new PersonDTO(x));
    }

    @Transactional
    public PersonDTO insert(PersonInsertDTO dto) {
        Person entity = new Person(dto);
        entity = personRepository.save(entity);
        return new PersonDTO(entity);
    }

    @Transactional
    public PersonDTO update(Long id, PersonInsertDTO dto) {
        try {
            Person entity = personRepository.getReferenceById(id);
            entity = personRepository.save(updateEntity(entity, dto));
            return new PersonDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Person with id: " + id + " not found");
        }
    }

    private Person updateEntity(Person entity, PersonInsertDTO dto) {
        entity.setFirstName(dto.firstName());
        entity.setLastName(dto.lastName());
        entity.setEmail(dto.email());
        entity.setAddress(dto.address());
        entity.setZipCode(dto.zipCode());
        entity.setPhoneNumber(dto.phoneNumber());
        return entity;
    }

    public PersonDTO buscarPorId(Long id) {
        Optional<Person> optional = personRepository.buscarPorId(id);
        if (!optional.isPresent()) {
            throw new IllegalArgumentException("Person with id: " + id + " not found");
        }
        return new PersonDTO(optional.get());
    }
}
