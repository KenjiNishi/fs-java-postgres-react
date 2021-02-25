package com.nsw.fsjavapostgresreact;

import com.nsw.fsjavapostgresreact.models.Lounge;
import com.nsw.fsjavapostgresreact.repositories.LoungeRepository;

import org.junit.jupiter.api.Assertions;    
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LoungeTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private final LoungeRepository repository;

    @Autowired
    public LoungeTests(LoungeRepository repository, TestEntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }
    
    @Test
    public void testSaveLounge(){
        Lounge lounge = new Lounge("Loungen");
        entityManager.persist(lounge);
        Lounge result = repository.findByName("Loungen").get();
        Assertions.assertTrue("Loungen"==result.getName());
    }

    @Test
    public void getLounge(){
        Lounge lounge = new Lounge("New");
        Lounge lounge2 = new Lounge("Newer");
        entityManager.persist(lounge);
        entityManager.persist(lounge2);

        repository.findByName("Newer")
                .map(newLounge ->{
                   Assertions.assertTrue("Newer"==newLounge.getName());
                   return true;
                });

    }

    @Test
    public void getLounges(){
        Lounge lounge = new Lounge("Lounge 1");
        Lounge lounge2 = new Lounge("Lounge 2");
        entityManager.persist(lounge);
        entityManager.persist(lounge2);
        Assertions.assertNotNull(repository.findAll());
    }

    @Test
    public void updateLounge() {
        entityManager.persist(new Lounge("Secret"));

        Lounge lounge = repository.findByName("Secret").get();
        lounge.setName("EvenMoreSecret");
        entityManager.persist(lounge);

        Lounge result = repository.findByName("EvenMoreSecret").get();
        Assertions.assertTrue("EvenMoreSecret"==result.getName());
    }

    @Test
    public void deleteLounge(){
        Lounge lounge = new Lounge("TheUnlikedOne");
        entityManager.persist(lounge);
        repository.deleteById(repository.findByName("TheUnlikedOne").get().getId());
        Assertions.assertTrue(!repository.findByName("TheUnlikedOne").isPresent());
    }

}
