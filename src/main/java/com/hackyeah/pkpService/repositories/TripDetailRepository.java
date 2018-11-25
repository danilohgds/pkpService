package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.entities.TripDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripDetailRepository extends MongoRepository<TripDetail, String> {
    Optional<TripDetail> findByTripId(String tripId);
    List<TripDetail> findAllByTrainId(String trainId);
    List<TripDetail> findAllByStartTimeAndEndTime(Instant startTime, Instant endTime);
}
