package com.nsw.fsjavapostgresreact.person.repository;
import com.nsw.fsjavapostgresreact.person.Person;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    @Query("SELECT s FROM Person s WHERE s.firstName=?1 AND s.lastName=?2")
    Optional<Person> findDuplicatePerson(String firstName, String lastName);
}
