package com.hackyeah.pkpService.mock.train;

import com.hackyeah.pkpService.entities.Seat;
import com.hackyeah.pkpService.entities.Train;
import com.hackyeah.pkpService.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.hackyeah.pkpService.entities.WagonType.byTypeId;

@Component
public class TrainDataMock {


    private TrainRepository trainRepository;


    @Autowired
    public TrainDataMock(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }


    public void createTrains() {

        for (int t = 0; t < 10; t++) {
            Train train = new Train();
            List<Seat> seats = new ArrayList<>();
            for (int w = 0; w <= 2; w++) {
                for (int s = 1; s <= 120; s++) {
                    Seat seat = new Seat();
                    seat.setSeatNumber(s);
                    seat.setWagonNumber(w + 1);
                    seat.setWagonType(byTypeId(w));
                    seats.add(seat);
                }
            }
            train.setSeats(seats);
            trainRepository.save(train);
        }


    }
}
