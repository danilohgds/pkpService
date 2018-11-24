package com.hackyeah.pkpService.entities;

import com.hackyeah.pkpService.relationships.Trip;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document("lost_items")
@Getter
@Setter
public class LostItem {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    private String description;

    private User user;

    private Trip trip;

    public LostItem(String name, String description, User user, Trip trip) {
        this.name = name;
        this.description = description;
        this.trip = trip;
        this.user = user;
    }
}
