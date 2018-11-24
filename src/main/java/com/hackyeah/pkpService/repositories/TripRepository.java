package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.relationships.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TripRepository extends CrudRepository<Trip, String> {
    List<Trip> findByStartCityAndEndCity(String startCityId, String endCityId);
    List<Trip> findByStartTime(Instant startTime);
}
