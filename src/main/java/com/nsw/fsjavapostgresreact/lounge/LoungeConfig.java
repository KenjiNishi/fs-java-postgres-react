package com.nsw.fsjavapostgresreact.models;

import com.nsw.fsjavapostgresreact.repositories.LoungeRepository;
import com.nsw.fsjavapostgresreact.models.Lounge;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class LoungeConfig {
    @Bean
    CommandLineRunner LoungeCommandLineRunner(LoungeRepository repository){
        return args -> {
            Lounge one = new Lounge(
                "Lounge 1"
            );
            Lounge two = new Lounge(
                "Better Lounge"
            );
            repository.saveAll(List.of(one, two));
        };
    };
}
