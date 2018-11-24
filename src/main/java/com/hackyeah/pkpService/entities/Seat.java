package com.hackyeah.pkpService.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {

    private Integer wagonNumber;

    private WagonType wagonType;

    private Integer seatNumber;

}
