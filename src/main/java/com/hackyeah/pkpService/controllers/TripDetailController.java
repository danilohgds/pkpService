package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.entities.TripDetail;
import com.hackyeah.pkpService.services.TripDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trip-details")
public class TripDetailController {

    private TripDetailService tripDetailService;

    @Autowired
    public TripDetailController(TripDetailService tripDetailService) {
        this.tripDetailService = tripDetailService;
    }

    @RequestMapping(value = "byTripId", method = RequestMethod.GET)
    public Optional<TripDetail> findByTripId(@RequestParam String tripId) {
        return tripDetailService.findByTripId(tripId);
    }

    @RequestMapping(value = "byTrainId", method = RequestMethod.GET)
    public List<TripDetail> findAllByTrinId(@RequestParam String trainId) {
        return tripDetailService.findAllByTrainId(trainId);
    }

    @RequestMapping(value = {"byStartDate", "byEndDate"}, method = RequestMethod.GET)
    public List<TripDetail> findByStartAndEndDate(Instant strartDate, Instant endDate) {
        return tripDetailService.findAllByStartAndEndTime(strartDate, endDate);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TripDetail create(@RequestBody TripDetail tripDetail) {
        return tripDetailService.create(tripDetail);
    }
}
