package com.hackyeah.pkpService.nodes.City;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NodeEntity
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @Relationship(type = "TRAVELS_TO", direction = Relationship.OUTGOING)
//    private List<City> travelsTo;
//
//    public void registerDirecion(City city) {
//        if (this.getTravelsTo() == null) {
//            this.travelsTo = new ArrayList<>();
//        }
//
//        if(!this.getTravelsTo().contains(city)){
//            this.travelsTo.add(city);
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof City)) return false;
//        City city = (City) o;
//        return Objects.equals(id, city.id) &&
//                Objects.equals(name, city.name) &&
//                Objects.equals(travelsTo, city.travelsTo);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, name, travelsTo);
//    }
}
