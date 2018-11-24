package com.hackyeah.pkpService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "wagon_number")
    private int wagonNumber;
    @Column(name = "number_of_places")
    private int numberOfPlaces;
    @OneToMany(mappedBy = "wagon")
    private Collection<Seat> seats;

    public Wagon(long id, int wagonNumber, int numberOfPlaces, Collection<Seat> seats) {
        this.id = id;
        this.wagonNumber = wagonNumber;
        this.numberOfPlaces = numberOfPlaces;
        this.seats = seats;
    }
}
