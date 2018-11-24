package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.entities.Train;
import com.hackyeah.pkpService.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/train")
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
