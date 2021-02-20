package com.nsw.fsjavapostgresreact.person.services;

import com.nsw.fsjavapostgresreact.person.Person;
import com.nsw.fsjavapostgresreact.person.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository){
		this.personRepository = personRepository;
	}

	public List<Person> getPersons(){
		return personRepository.findAll();
	}

	public void addNewPerson(Person person){
		Optional<Person> checkClone = personRepository.findDuplicatePerson(person.getFirstName(), person.getLastName());
		if (checkClone.isPresent()) { throw new IllegalStateException("Person with same first and last name already exists!!!");}
		personRepository.save(person);
	}

	public void  deletePerson(Long personId){
		boolean exists = personRepository.existsById(personId);
		if(!exists){ throw new IllegalStateException("Person id does not exist: " + personId);}
		personRepository.deleteById(personId);
	}
}
