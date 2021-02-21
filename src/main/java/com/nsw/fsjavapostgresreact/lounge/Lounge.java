package com.nsw.fsjavapostgresreact.lounge;

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
public class Lounge {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lounge_sequence")
    @SequenceGenerator(name="lounge_sequence", sequenceName="lounge_seq")
    private Long id;
    private String name;

    public Lounge( String name){
        this.name = name;
    }

}