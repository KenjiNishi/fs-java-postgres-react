package com.nsw.fsjavapostgresreact.person.services;

import com.nsw.fsjavapostgresreact.person.Person;
import com.nsw.fsjavapostgresreact.person.repository.PersonRepository;

import java.util.List;
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
}
