package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.entities.Seat;
import com.hackyeah.pkpService.entities.Train;
import com.hackyeah.pkpService.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    public Set<Seat> findSeatsByWagonType(String id, int wagonType) {
        Optional<Train> trainOptional = trainRepository.findById(id);

        if (!trainOptional.isPresent()) {
            throw new IllegalArgumentException("Train with given number doesn't exist");
        }

        return trainOptional.get().getSeats().stream().filter(seat -> seat.getWagonType().getTypeId() == wagonType)
                .collect(Collectors.toSet());
    }

    public List<Seat> findSeatsByTrainId(String id) {
        Optional<Train> trainOptional = trainRepository.findById(id);

        if (!trainOptional.isPresent()) {
            throw new IllegalArgumentException("Train with given number doesn't exist");
        }

        return trainOptional.get().getSeats();
    }
}
