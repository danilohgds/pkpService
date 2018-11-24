package com.hackyeah.pkpService.user.controller;

import com.hackyeah.pkpService.entities.User;
import com.hackyeah.pkpService.user.dto.Authorization;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/authorize", method = POST)
    public User authorize(@RequestBody Authorization authorization) {
        if (authorization.getPassword().equals("epam2018")) {
            return new User(
                    UUID.randomUUID().toString(),
                    "PKP",
                    "PKP",
                    "pkp@pkp.pl",
                    "+48-123-456-789"
            );
        }

        throw new IllegalArgumentException("Username or Password is incorrect");
    }

}
