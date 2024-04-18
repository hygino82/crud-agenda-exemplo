package br.dev.hygino.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.dev.hygino.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select obj from Person obj where obj.id = :id")
    Optional<Person> buscarPorId(Long id);
}
