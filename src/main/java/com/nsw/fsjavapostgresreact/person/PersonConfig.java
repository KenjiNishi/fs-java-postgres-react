package com.nsw.fsjavapostgresreact.person;

import com.nsw.fsjavapostgresreact.person.repository.PersonRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            
        };
    };
}
