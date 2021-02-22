package com.nsw.fsjavapostgresreact;

import com.nsw.fsjavapostgresreact.person.Person;
import com.nsw.fsjavapostgresreact.person.repository.PersonRepository;

import org.junit.jupiter.api.Assertions;    
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersonTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    public PersonTests(PersonRepository personRepository, TestEntityManager entityManager) {
        this.personRepository = personRepository;
        this.entityManager = entityManager;
    }
    
    @Test
    public void testSavePerson(){
        Person person = new Person("Tester","Testerson");
        entityManager.persist(person);
        Person result = personRepository.findByFirstName("Tester").get();
        //.get() to pass from Optional<Person> to <Person> type
        Assertions.assertTrue("Tester"==result.getFirstName());
    }

    @Test
    public void getPerson(){
        Person person = new Person("John","Doe");
        Person person2 = new Person("Snake","Pliskin");
        entityManager.persist(person);
        entityManager.persist(person2);

        personRepository.findByFirstName("Snake")
                .map(newPerson ->{
                   Assertions.assertTrue("Snake"==newPerson.getFirstName());
                   return true;
                });

    }

    @Test
    public void getPersons(){
        Person person = new Person("Jane","Doe");
        Person person2 = new Person("Jerry","Smith");
        entityManager.persist(person);
        entityManager.persist(person2);
        Assertions.assertNotNull(personRepository.findAll());
    }

    @Test
    public void updatePerson() {
        entityManager.persist(new Person("BondJames","Bond"));

        Person person = personRepository.findByFirstName("BondJames").get();
        person.setFirstName("Spy");
        entityManager.persist(person);

        Person result = personRepository.findByFirstName("Spy").get();
        Assertions.assertTrue("Spy"==result.getFirstName());
    }

    @Test
    public void deletePerson(){
        Person person = new Person("Jonas","Connor");
        entityManager.persist(person);
        personRepository.deleteById(personRepository.findByFirstName("Jonas").get().getId());
        Assertions.assertTrue(!personRepository.findByFirstName("Jonas").isPresent());
    }

}
