package com.nsw.fsjavapostgresreact.person.services;

import com.nsw.fsjavapostgresreact.person.Person;
import com.nsw.fsjavapostgresreact.person.repository.PersonRepository;

import java.util.Objects;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public Person getPerson(Long personId){
		Person person = personRepository.findById(personId)
			.orElseThrow(() -> new IllegalStateException("Person id does not exist: " + personId));
		return person;
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

	@Transactional
	public void updatePerson(Long personId, Person updated){
		Person person = personRepository.findById(personId)
			.orElseThrow(() -> new IllegalStateException("Person id does not exist: " + personId));

			if (updated.getFirstName()!=null && updated.getFirstName().length()>0 &&
					!Objects.equals(person.getFirstName(), updated.getFirstName()))
				{
				person.setFirstName(updated.getFirstName());
				}
			if (updated.getLastName()!=null && updated.getLastName().length()>0 &&
					!Objects.equals(person.getLastName(), updated.getLastName()))
				{
				person.setLastName(updated.getLastName());
				}
			if (updated.getLoungeRoom()!=null &&
				!Objects.equals(person.getLoungeRoom(), updated.getLoungeRoom()))
				{
				person.setLoungeRoom(updated.getLoungeRoom());
				}
			if (updated.getEventRoom1()!=null &&
				!Objects.equals(person.getEventRoom1(), updated.getEventRoom1()))
				{
				person.setEventRoom1(updated.getEventRoom1());
				}
	}
}
