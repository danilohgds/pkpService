package com.hackyeah.pkpService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WagonService {

    private WagonService wagonService;

    @Autowired
    public WagonService(WagonService wagonService) {
        this.wagonService = wagonService;
    }

    
}
