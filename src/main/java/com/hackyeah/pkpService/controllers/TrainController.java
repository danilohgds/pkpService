package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.entities.Train;
import com.hackyeah.pkpService.entities.WagonType;
import com.hackyeah.pkpService.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {

    private TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Train create(@RequestBody Train train) {
        return trainService.create(train);
    }

    @RequestMapping(value = "all")
    public List<Train> findAll() {
        return trainService.findAll();
    }


}
