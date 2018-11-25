package com.hackyeah.pkpService.mock.city;

import com.hackyeah.pkpService.city.repositories.CityRepository;
import com.hackyeah.pkpService.entities.Train;
import com.hackyeah.pkpService.entities.TripDetail;
import com.hackyeah.pkpService.nodes.City.City;
import com.hackyeah.pkpService.relationships.Trip;
import com.hackyeah.pkpService.repositories.TripDetailRepository;
import com.hackyeah.pkpService.repositories.TripRepository;
import com.hackyeah.pkpService.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class CityDataMock {


    private final TrainService trainService;
    private CityRepository cityRepository;
    private CityMongoRepository cityMongoRepository;
    private TripRepository tripRepository;

    @Autowired
    public CityDataMock(CityRepository cityRepository, CityMongoRepository cityMongoRepository,
                        TrainService trainService, TripRepository tripRepository) {
        this.cityRepository = cityRepository;
        this.cityMongoRepository = cityMongoRepository;
        this.trainService = trainService;
        this.tripRepository = tripRepository;
    }

    public void create() {

        cityRepository.deleteAll();
        cityMongoRepository.findAll().forEach(cityMongo -> {
            City city = new City();
            city.setName(cityMongo.getName());
            cityRepository.save(city);
        });

    }

    public void createTrips() {

        tripRepository.deleteAll();

        List<City> cities = (List<City>) cityRepository.findAll();
        List<Train> trains = trainService.findAll();

        City c1 = cities.get(0);
        City c2 = cities.get(1);
        City c3 = cities.get(2);
        City c4 = cities.get(3);

        // C1 to c2
        Trip t1 = new Trip();
        t1.setTrainId(trains.get(0).getId());
        t1.setStartCity(c1);
//        c1.registerDirecion(c2);
        t1.setEndCity(c2);
        Trip save = tripRepository.save(t1);
        createTripDetail(save, 90);
//        cityRepository.save(c1);

        Trip t2 = new Trip();
        t2.setTrainId(trains.get(1).getId());
        t2.setStartCity(c1);
        t2.setEndCity(c2);
//        c1.registerDirecion(c2);
        Trip save1 = tripRepository.save(t2);
        createTripDetail(save1, 120);
//        cityRepository.save(c1);

        // c2 to c1
        Trip t3 = new Trip();
        t3.setTrainId(trains.get(2).getId());
        t3.setStartCity(c2);
        t3.setEndCity(c1);
//        c2.registerDirecion(c1);
        Trip save2 = tripRepository.save(t3);
//        cityRepository.save(c2);
        createTripDetail(save2, 75);

        // c2 to c3
        Trip t4 = new Trip();
        t4.setTrainId(trains.get(1).getId());
        t4.setStartCity(c2);
        t4.setEndCity(c3);
//        c2.registerDirecion(c3);
        createTripDetail(tripRepository.save(t4), 85);
//        cityRepository.save(c2);


        Trip t5 = new Trip();
        t5.setTrainId(trains.get(2).getId());
        t5.setStartCity(c2);
        t5.setEndCity(c3);
//        c2.registerDirecion(c3);
        createTripDetail(tripRepository.save(t5), 130);
//        cityRepository.save(c2);

        // c3 to c2
        Trip t6 = new Trip();
        t6.setTrainId(trains.get(0).getId());
        t6.setStartCity(c3);
        t6.setEndCity(c2);
//        c3.registerDirecion(c2);
        createTripDetail(tripRepository.save(t6), 110);
//        cityRepository.save(c3);

        // c1 to c4
        Trip t7 = new Trip();
        t7.setTrainId(trains.get(2).getId());
        t7.setStartCity(c1);
        t7.setEndCity(c4);
//        c1.registerDirecion(c4);
        createTripDetail(tripRepository.save(t7), 95);
//        cityRepository.save(c1);
    }

    @Autowired
    private TripDetailRepository tripDetailRepository;

    private void createTripDetail(Trip save, int duration) {
        Instant now = Instant.now();
        TripDetail tripDetail = new TripDetail();
        tripDetail.setStartTime(now);
        tripDetail.setTrainId(save.getTrainId());
        tripDetail.setTripId(save.getId());
        tripDetail.setEndTime(now.plus(duration, ChronoUnit.MINUTES));

        tripDetailRepository.save(tripDetail);
    }
}
