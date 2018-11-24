package com.hackyeah.pkpService.mock.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock/train")
public class TrainMockController {

    private TrainDataMock trainDataMock;

    @Autowired
    public TrainMockController(TrainDataMock trainDataMock) {
        this.trainDataMock = trainDataMock;
    }

    @RequestMapping("/run")
    public String mock(){
        trainDataMock.createTrains();

        return "MOCKED";
    }
}
