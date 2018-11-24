package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.repositories.WagonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WagonService {

    private WagonRepository wagonRepository;

    @Autowired
    public WagonService(WagonRepository wagonRepository) {
        this.wagonRepository = wagonRepository;
    }
}
