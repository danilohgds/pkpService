package com.hackyeah.pkpService.relationships;

import com.hackyeah.pkpService.entities.Seat;
import com.hackyeah.pkpService.nodes.City.City;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@RelationshipEntity(type = "TRAVELS_TO")
public class Trip {

    @Id
    @GeneratedValue
    private String id;

    @StartNode
    private City startCity;
    @EndNode
    private City endCity;

    private String trainId;

    private Instant startTime;

    private Instant endTime;

    private List<Seat> allocatedSeats;

    private List<Seat> freeSeats;
}
