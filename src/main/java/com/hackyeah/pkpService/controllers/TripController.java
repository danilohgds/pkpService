package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.relationships.Trip;
import com.hackyeah.pkpService.services.TripService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @RequestMapping(value = {"byStartCity", "byEndCity"}, method = RequestMethod.GET)
    public List<Trip> findByStartCityAndEndCity(@RequestParam String startCityId, @RequestParam String endCityId) {
        return tripService.findTripByStartCityAndEndCity(startCityId, startCityId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Trip create(Trip trip) {
        return tripService.create(trip);
    }

    @RequestMapping(value = "byStartTime", method = RequestMethod.GET)
    public List<Trip> findByStartTime(@RequestParam Instant startTime) {
        return tripService.findTripByStartTime(startTime);
    }

}
