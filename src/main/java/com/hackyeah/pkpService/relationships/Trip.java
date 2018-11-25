package com.hackyeah.pkpService.relationships;

import com.hackyeah.pkpService.nodes.City.City;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@Getter
@Setter
@RelationshipEntity(type = "TRAVELS_TO")
public class Trip {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private City startCity;
    @EndNode
    private City endCity;

    private String trainId;
}
