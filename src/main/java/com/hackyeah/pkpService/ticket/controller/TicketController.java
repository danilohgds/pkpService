package com.hackyeah.pkpService.ticket.controller;

import com.hackyeah.pkpService.ticket.entities.PurchasedTicket;
import com.hackyeah.pkpService.ticket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    @RequestMapping(value = "buy", method = RequestMethod.POST)
//    public PurchasedTicket buy(@RequestBody PurchasedTicket ticket) {
//        return ticketService.buy(ticket);
//    }
//
//    @RequestMapping("byUsername")
//    public List<PurchasedTicket> findByUsername(@RequestParam String username) {
//        return ticketService.findByUsername(username);
//    }
}
