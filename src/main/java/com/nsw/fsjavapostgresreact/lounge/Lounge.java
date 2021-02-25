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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Lounge {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lounge_sequence")
    @SequenceGenerator(name="lounge_sequence", sequenceName="lounge_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "loungeRoom")
    private List<Person> guestIds;

    public Lounge( String name){
        this.name = name;
    }

}