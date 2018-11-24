package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.entities.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainRepository extends MongoRepository<Train, String> {
    Optional<Train> findById(String id);
}
