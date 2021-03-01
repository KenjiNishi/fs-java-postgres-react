package com.nsw.fsjavapostgresreact.models;

import com.nsw.fsjavapostgresreact.models.Person;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToMany(mappedBy = "eventRoom1")
    @JsonIgnore
    private List<Person> guestIds1;
    @OneToMany(mappedBy = "eventRoom2")
    @JsonIgnore
    private List<Person> guestIds2;

    @Transient
    private int currentOccupation1;
    @Transient
    private int currentOccupation2;

    public Room( String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public int getCurrentOccupation1(){return guestIds1.size();}
    public int getCurrentOccupation2(){return guestIds2.size();}
}