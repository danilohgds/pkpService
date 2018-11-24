package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.entities.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends MongoRepository<Train, String> {
}
