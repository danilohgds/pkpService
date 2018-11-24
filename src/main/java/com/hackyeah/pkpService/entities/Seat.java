package com.hackyeah.pkpService.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private long seatId;
    @Column(name = "seat_number")
    private int number;
    @ManyToOne
    private Wagon wagon;

    public Seat(long seatId, int number, Wagon wagon) {
        this.seatId = seatId;
        this.number = number;
        this.wagon = wagon;
    }
}
