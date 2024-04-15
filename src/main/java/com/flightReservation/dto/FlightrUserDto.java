package com.flightReservation.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightrUserDto {

    private Long id;

    private String firstName;
    private String lastName;

    private String email;

    private String username;

    private String userRole;

    private Long mobile;
    private String password;
}
