package com.nsw.fsjavapostgresreact.room;

import com.nsw.fsjavapostgresreact.room.repository.RoomRepository;
import com.nsw.fsjavapostgresreact.room.Room;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class RoomConfig {
    @Bean
    CommandLineRunner RoomCommandLineRunner(RoomRepository repository){
        return args -> {
            Room one = new Room(
                "Room 1",
                122
            );
            Room two = new Room(
                "Better Room",
                123
            );
            repository.saveAll(List.of(one, two));
        };
    };
}
