package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.nodes.City.City;
import com.hackyeah.pkpService.relationships.Trip;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TripRepository extends Neo4jRepository<Trip, Long> {


    @Query("MATCH  p=allShortestPaths((startNode:City)-[:TRAVELS_TO*]->(endNode:City) ) " +
            "where startNode.name={start} and endNode.name={end} return p  limit 25")
    List<Trip> findRoute(@Param("start") String start,@Param("end") String end);
}
