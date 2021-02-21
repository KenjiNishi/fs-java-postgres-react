package com.nsw.fsjavapostgresreact.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data - bundles @toString, @EqualsAndHashCode, @Getter/@Setter and @RequiredArgsConstructor.
// @NoArgsConstructor provides the default construct 
// @AllArgsConstructor bundles the non default constructor.

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_sequence")
    @SequenceGenerator(name="room_sequence", sequenceName="room_seq")
    private Long id;
    private String name;
    private int capacity;

    public Room( String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

}