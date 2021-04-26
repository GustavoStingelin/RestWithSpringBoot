package br.com.stingelin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stingelin.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
