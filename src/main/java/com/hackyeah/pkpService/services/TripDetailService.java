package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.entities.TripDetail;
import com.hackyeah.pkpService.repositories.TripDetailRepository;
import com.hackyeah.pkpService.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TripDetailService {

    private TripDetailRepository tripDetailRepository;

    @Autowired
    public TripDetailService(TripDetailRepository tripDetailRepository) {
        this.tripDetailRepository = tripDetailRepository;
    }

    public Optional<TripDetail> findByTripId(String tripId) {
        return tripDetailRepository.findByTripId(tripId);
    }

    public List<TripDetail> findAlllByTrainId(String trainId) {
        return tripDetailRepository.findAllByTrainId(trainId);
    }

    public List<TripDetail> findAllByStartAndEndTime(Instant startTime, Instant endTime) {
        return tripDetailRepository.findAllByStrartAndEndTime(startTime, endTime);
    }

    public TripDetail create(TripDetail tripDetail) {
        return tripDetailRepository.save(tripDetail);
    }
}
