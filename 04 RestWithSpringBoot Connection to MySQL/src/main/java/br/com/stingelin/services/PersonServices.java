package br.com.stingelin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stingelin.exception.ResourceNotFoundException;
import br.com.stingelin.model.Person;
import br.com.stingelin.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		repository.delete(entity);
	}
}
