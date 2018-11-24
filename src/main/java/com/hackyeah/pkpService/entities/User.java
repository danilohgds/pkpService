package com.hackyeah.pkpService.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document("users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    public User(String id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
