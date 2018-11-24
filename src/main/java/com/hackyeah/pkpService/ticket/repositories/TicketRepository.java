package com.hackyeah.pkpService.ticket.repositories;

import com.hackyeah.pkpService.entities.Seat;
import com.hackyeah.pkpService.ticket.entities.PurchasedTicket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends MongoRepository<PurchasedTicket, String> {

    Optional<PurchasedTicket> findByTrainIdAndTripId(String trainId, String tripId);

    List<PurchasedTicket> findByUserName(String userName);

    List<PurchasedTicket> findByTrainIdAndSeatIn(String trainId, List<Seat> seats);
}
