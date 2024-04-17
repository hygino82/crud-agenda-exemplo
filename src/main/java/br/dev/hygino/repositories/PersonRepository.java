package br.dev.hygino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dev.hygino.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
