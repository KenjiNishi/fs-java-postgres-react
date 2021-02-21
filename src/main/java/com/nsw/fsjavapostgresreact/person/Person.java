package com.nsw.fsjavapostgresreact.person;

import com.nsw.fsjavapostgresreact.lounge.Lounge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="person_sequence")
    @SequenceGenerator(name="person_sequence", sequenceName="person_seq")
    private Long id;

    private String firstName;
    private String lastName; 
    @ManyToOne
    @JoinColumn(name = "lounge_id", referencedColumnName="ID")
    private Lounge loungeRoom;

    protected Person(){}

    public Person(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public Lounge getLoungeRoom() {
        return loungeRoom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setLoungeRoom(Lounge loungeRoom) {
        this.loungeRoom = loungeRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
