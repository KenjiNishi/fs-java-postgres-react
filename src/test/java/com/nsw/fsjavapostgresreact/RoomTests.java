package com.nsw.fsjavapostgresreact;

import com.nsw.fsjavapostgresreact.room.Room;
import com.nsw.fsjavapostgresreact.room.repository.RoomRepository;

import org.junit.jupiter.api.Assertions;    
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoomTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private final RoomRepository repository;

    @Autowired
    public RoomTests(RoomRepository repository, TestEntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }
    
    @Test
    public void testSaveRoom(){
        Room room = new Room("Room", 123);
        entityManager.persist(room);
        Room result = repository.findByName("Room").get();
        Assertions.assertTrue("Room"==result.getName());
    }

    @Test
    public void getRoom(){
        Room room = new Room("New", 122);
        Room room2 = new Room("Newer", 123);
        entityManager.persist(room);
        entityManager.persist(room2);

        repository.findByName("Newer")
                .map(newRoom ->{
                   Assertions.assertTrue("Newer"==newRoom.getName());
                   return true;
                });

    }

    @Test
    public void getRooms(){
        Room room = new Room("Room 1", 123);
        Room room2 = new Room("Room 2", 122);
        entityManager.persist(room);
        entityManager.persist(room2);
        Assertions.assertNotNull(repository.findAll());
    }

    @Test
    public void updateRoom() {
        entityManager.persist(new Room("Secret",123));

        Room room = repository.findByName("Secret").get();
        room.setName("StillTheSame");
        entityManager.persist(room);

        Room result = repository.findByName("StillTheSame").get();
        Assertions.assertTrue("StillTheSame"==result.getName());
    }

    @Test
    public void deleteRoom(){
        Room room = new Room("NotGood",123);
        entityManager.persist(room);
        repository.deleteById(repository.findByName("NotGood").get().getId());
        Assertions.assertTrue(!repository.findByName("NotGood").isPresent());
    }

}
