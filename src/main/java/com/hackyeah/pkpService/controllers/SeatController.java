package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.entities.Seat;
import com.hackyeah.pkpService.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/seats")
public class SeatController {

    private TrainService trainService;

    @Autowired
    public SeatController(TrainService trainService) {
        this.trainService = trainService;
    }


    @RequestMapping(value = "byWagonType")
    public Set<Seat> findByWagonClass(@RequestParam String trainNumber, @RequestParam int wagonType){
        return trainService.findSeatsByWagonType(trainNumber,wagonType);
    }

}
