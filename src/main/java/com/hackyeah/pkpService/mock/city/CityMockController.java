package com.hackyeah.pkpService.mock.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock/city")
public class CityMockController {

    private CityDataMock cityDataMock;

    @Autowired
    public CityMockController(CityDataMock cityDataMock) {
        this.cityDataMock = cityDataMock;
    }

    @RequestMapping("/run")
    public String run() {
        cityDataMock.create();

        return "MOCKED";
    }
}
