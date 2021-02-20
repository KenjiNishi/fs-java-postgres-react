package com.nsw.fsjavapostgresreact.person;

import com.nsw.fsjavapostgresreact.person.repository.PersonRepository;
import com.nsw.fsjavapostgresreact.person.Person;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            Person one = new Person(
                1L,
                "Neo",
                "Doe"
            );
            Person two = new Person(
                2L,
                "Pandora",
                "Doe"
            );
            repository.saveAll(List.of(one, two));
            
        };
    };
}
