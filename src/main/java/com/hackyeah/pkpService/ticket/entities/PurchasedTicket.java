package com.hackyeah.pkpService.ticket.entities;

import com.hackyeah.pkpService.entities.Seat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@Document("purchased_tickets")
public class PurchasedTicket {

    @Id
    private String id;

    private String tripId;

    private String userName;

    private String passengerFullName;

    private String passengerPhoneNumber;

    private String passengerEmail;

    private String trainId;

    private Seat seat;
}
