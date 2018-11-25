package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.relationships.Trip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends Neo4jRepository<Trip, Long> {
}
