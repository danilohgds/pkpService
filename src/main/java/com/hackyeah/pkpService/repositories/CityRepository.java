package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.nodes.City.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, String> {
}
