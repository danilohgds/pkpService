package com.hackyeah.pkpService.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Seat {

    private Integer wagonNumber;

    private WagonType wagonType;

    private Integer seatNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return Objects.equals(wagonNumber, seat.wagonNumber) &&
                wagonType == seat.wagonType &&
                Objects.equals(seatNumber, seat.seatNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wagonNumber, wagonType, seatNumber);
    }
}
