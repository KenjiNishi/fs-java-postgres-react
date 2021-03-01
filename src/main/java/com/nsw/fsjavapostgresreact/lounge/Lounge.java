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
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lounge {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lounge_sequence")
    @SequenceGenerator(name="lounge_sequence", sequenceName="lounge_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "loungeRoom")
    @JsonBackReference
    private List<Person> guestIds;

    @Transient
    private int currentOccupation;

    public Lounge( String name){
        this.name = name;
    }

    public int getCurrentOccupation(){return guestIds.size();}
    public void setCurrentOccupation(int oc){ this.currentOccupation = oc;}
}