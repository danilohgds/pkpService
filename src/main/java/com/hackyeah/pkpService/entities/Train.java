package com.hackyeah.pkpService.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Document("trains")
@Getter
@Setter
public class Train {

    @Id
    @GeneratedValue
    private String id;

    private List<Seat> seats;

}
