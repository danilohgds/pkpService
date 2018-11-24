package com.hackyeah.pkpService.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WagonRepository extends MongoRepository<Wagon, String> {

}
