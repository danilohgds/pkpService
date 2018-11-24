package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.relationships.Trip;
import com.hackyeah.pkpService.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TripService {

    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> findTripByStartCityAndEndCity(String startCityId, String endCityId) {
        return tripRepository.findByStartCityAndEndCity(startCityId, endCityId);
    }

    public List<Trip> findTripByStartTime(Instant startTime){
        return tripRepository.findByStartTime(startTime);
    }
}
