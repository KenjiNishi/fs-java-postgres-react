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
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
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
        Person result = personRepository.findById(new Long(1)).get();
        //.get() to pass from Optional<Person> to <Person> type
        Assertions.assertTrue("Tester"==result.getFirstName());
    }

}
