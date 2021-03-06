package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.entities.Train;
import com.hackyeah.pkpService.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    private TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train create(Train train) {
        return trainRepository.save(train);
    }
}
