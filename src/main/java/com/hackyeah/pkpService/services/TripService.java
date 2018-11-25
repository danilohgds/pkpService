package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.relationships.Trip;
import com.hackyeah.pkpService.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip create(Trip trip) {
        return tripRepository.save(trip);
    }


    public List<Trip> findRoute1(String start, String end) {
        return tripRepository.findRoute(start, end);
    }
}
