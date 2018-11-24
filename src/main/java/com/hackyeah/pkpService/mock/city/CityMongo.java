package com.hackyeah.pkpService.mock.city;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@Document("cities")
public class CityMongo {

    @Id
    private String id;

    private String name;
}
