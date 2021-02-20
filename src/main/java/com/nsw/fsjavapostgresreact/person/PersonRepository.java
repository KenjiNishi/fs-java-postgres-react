package com.nsw.fsjavapostgresreact.person.repository;
import com.nsw.fsjavapostgresreact.person.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
