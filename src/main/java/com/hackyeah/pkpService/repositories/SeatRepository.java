package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.entities.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends MongoRepository<Seat, String> {
}
