package com.nsw.fsjavapostgresreact.person.controllers;

import com.nsw.fsjavapostgresreact.person.Person;
import com.nsw.fsjavapostgresreact.person.services.PersonService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping
	public List<Person> getPersons(){
		return personService.getPersons();
	}

    @PostMapping
    public void registerPerson(@RequestBody Person person){
        personService.addNewPerson(person);

    }

    @DeleteMapping(path="{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        personService.deletePerson(personId);
    }

    
}
