package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.entities.Wagon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WagonRepository extends CrudRepository<Wagon, Long> {

}
