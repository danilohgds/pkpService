package com.hackyeah.pkpService.entities;

import com.hackyeah.pkpService.ticket.entities.PurchasedTicket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.List;

@Document("trip_details")
@Getter
@Setter
@NoArgsConstructor
public class TripDetail {

    @Id
    @GeneratedValue
    private String id;
    private String tripId;
    private String trainId;
    private Instant startTime;
    private Instant endTime;
    private String price;
    private List<PurchasedTicket> soldTickets;

    public TripDetail(String id, String trainId, Instant startTime, Instant endTime, String price, List<PurchasedTicket> soldTickets) {
        this.id = id;
        this.trainId = trainId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.soldTickets = soldTickets;
    }
}
