package com.hackyeah.pkpService.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Document
@Getter
@Setter
public class Train {

    @Id
    @GeneratedValue
    private String id;

    private String trainNumber;

    private Set<Seat> seats;

}
