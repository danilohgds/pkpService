package com.hackyeah.pkpService.dto;

import com.hackyeah.pkpService.entities.TripDetail;
import com.hackyeah.pkpService.nodes.City.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Station {

    private City city;
    private TripDetail tripDetail;
    private Station next;

    public Station(City city, TripDetail tripDetail) {
        this.city = city;
        this.tripDetail = tripDetail;
    }

    public Station(City city, TripDetail tripDetail, Station next) {
        this.city = city;
        this.tripDetail = tripDetail;
        this.next = next;
    }
}
