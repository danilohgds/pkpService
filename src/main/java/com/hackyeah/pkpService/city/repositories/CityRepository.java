package com.hackyeah.pkpService.city.repositories;

import com.hackyeah.pkpService.nodes.City.City;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CityRepository extends Neo4jRepository<City,String> {
}
