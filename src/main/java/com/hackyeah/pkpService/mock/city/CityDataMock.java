package com.hackyeah.pkpService.mock.city;

import com.hackyeah.pkpService.city.repositories.CityRepository;
import com.hackyeah.pkpService.nodes.City.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityDataMock {


    private CityRepository cityRepository;
    private CityMongoRepository cityMongoRepository;


    @Autowired
    public CityDataMock(CityRepository cityRepository, CityMongoRepository cityMongoRepository) {
        this.cityRepository = cityRepository;
        this.cityMongoRepository = cityMongoRepository;
    }

    public void create() {

        cityRepository.deleteAll();
        cityMongoRepository.findAll().forEach(cityMongo -> {
            City city = new City();
            city.setName(cityMongo.getName());
            cityRepository.save(city);
        });
    }
}
