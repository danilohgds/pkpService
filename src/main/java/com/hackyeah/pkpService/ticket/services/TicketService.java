package com.hackyeah.pkpService.ticket.services;

import com.hackyeah.pkpService.entities.Seat;
import com.hackyeah.pkpService.ticket.entities.PurchasedTicket;
import com.hackyeah.pkpService.ticket.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class TicketService {


    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


//    public PurchasedTicket buy(PurchasedTicket ticket) {
//
//        String trainId = ticket.getTrainId();
//
//        Optional<PurchasedTicket> purchasedOptional = ticketRepository.findByTrainIdAndTripId(trainId, tripId);
//
//        if (purchasedOptional.isPresent()) {
//            throw new IllegalArgumentException("This place is already purchased, Would you like to contact the owner" +
//                    "to ask change ?");
//        }
//
//        return ticketRepository.save(ticket);
//    }
//
//    public List<PurchasedTicket> buyMany(List<PurchasedTicket> tickets) {
//
//        if (tickets.isEmpty()) {
//            throw new IllegalArgumentException("Tickets size should not me empty");
//        }
//
//        String trainId = tickets.get(0).getTrainId();
//        List<Seat> seats = tickets.stream().map(PurchasedTicket::getSeat).collect(toList());
//
//        List<PurchasedTicket> purchased = ticketRepository.findByTrainIdAndSeatIn(trainId, seats);
//
//        if (!purchased.isEmpty()) {
//            throw new IllegalArgumentException("Some places are already purchased, Would you like to contact the owner(s)" +
//                    "to ask change ?");
//        }
//
//        return ticketRepository.saveAll(tickets);
//    }
//
//    public List<PurchasedTicket> findByUsername(String username) {
//        return ticketRepository.findByUserName(username);
//    }
}
