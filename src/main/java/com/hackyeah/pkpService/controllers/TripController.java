package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.dto.Station;
import com.hackyeah.pkpService.relationships.Trip;
import com.hackyeah.pkpService.services.TripService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Trip create(Trip trip) {
        return tripService.create(trip);
    }


    @RequestMapping("/route/{start}/to/{end}")
    public List<Station> findRoute(@PathVariable String start, @PathVariable String end) {
        return tripService.findRoute(start, end);
    }

}
