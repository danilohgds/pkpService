package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.dto.Station;
import com.hackyeah.pkpService.entities.TripDetail;
import com.hackyeah.pkpService.relationships.Trip;
import com.hackyeah.pkpService.repositories.TripDetailRepository;
import com.hackyeah.pkpService.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    private final TripDetailRepository tripDetailRepository;
    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository, TripDetailRepository tripDetailRepository) {
        this.tripRepository = tripRepository;
        this.tripDetailRepository = tripDetailRepository;
    }

    public Trip create(Trip trip) {
        return tripRepository.save(trip);
    }

    private List<Station> getLayovers(List<Trip> allTrips, List<TripDetail> startPointDetails, String end, String destination) {
        List<Station> result = new ArrayList<>();
        allTrips.stream()
                .filter(trip -> trip.getStartCity().getName().equalsIgnoreCase(end)).forEach(trip -> {
            boolean finish = false;
            while (!finish) {
                TripDetail detail = getDetailByTripId(startPointDetails, trip.getId());
                Station station = new Station(trip.getStartCity(), detail);
                if (destination.equalsIgnoreCase(trip.getEndCity().getName())) {
                    station.setNext(new Station(trip.getEndCity(), detail));
                    result.add(station);
                    finish = true;
                }
                List<Trip> nextStarts = getNextStarts(allTrips, trip.getEndCity().getName());
                List<Station> nextStations = getLayovers(nextStarts, startPointDetails, trip.getEndCity().getName(), destination);
                result.addAll(nextStations);
            }
        });

        return result;
    }

    public List<Station> findRoute(String start, String end) {
        List<Station> routes = new ArrayList<>();
        List<Trip> allTrips = tripRepository.findRoute(start, end);
        List<Long> tripIds = allTrips.stream()
                .map(Trip::getId).collect(Collectors.toList());

        List<TripDetail> tripDetails = tripDetailRepository.findByTripIdIn(tripIds);

        allTrips.stream().filter(trip -> trip.getStartCity().getName().equalsIgnoreCase(start))
                .forEach(trip -> {
                    TripDetail detail = getDetailByTripId(tripDetails, trip.getId());
                    System.out.println(start + "   " + detail.getTripId());
                    List<Station> layovers = getLayovers(allTrips, tripDetails, trip.getEndCity().getName(), end);
                    layovers.forEach(layover -> {
                        Station station = new Station(trip.getStartCity(), detail);
                        station.setNext(layover);
                        routes.add(station);
                    });
                });


        return routes;
    }

    private TripDetail getDetailByTripId(List<TripDetail> details, long tripId) {
        return details.stream().filter(tripDetail -> tripDetail.getTripId().equals(tripId)).findFirst().get();
    }

    private List<Trip> getNextStarts(List<Trip> trips, String endId) {
        return trips.stream().filter(trip -> trip.getStartCity().getName().equals(endId)).
                collect(Collectors.toList());
    }
}
