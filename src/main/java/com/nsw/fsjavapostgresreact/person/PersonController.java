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

    @GetMapping(path = "{personId}")
    public Person getPerson(@PathVariable("personId") Long personId){
        return personService.getPerson(personId);
    }

    @GetMapping
	public List<Person> getPersons(){
		return personService.getPersons();
	}

    @PostMapping
    public void registerPerson(@RequestBody Person person){
        personService.addNewPerson(person);

    }

    @PutMapping(path = "{personId}")
    public void registerPerson(
            @PathVariable("personId") Long personId,
            @RequestBody Person personData){
                personService.updatePerson(personId, personData);
            }

    @DeleteMapping(path="{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        personService.deletePerson(personId);
    }

    
}
