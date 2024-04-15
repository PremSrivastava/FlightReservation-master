package com.flightReservation.controller;

import com.flightReservation.dto.FlightrUserDto;
import com.flightReservation.entity.FlightUser;
import com.flightReservation.services.FlightServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private FlightServcie flightServcie;
   //http://localhost:8080/api/v1/users/addUser
    @PostMapping("/addUser")
    public ResponseEntity<String> addFlight(@RequestBody FlightrUserDto dto){
        FlightUser flightUser = flightServcie.addFlightUser(dto);
        if(flightUser != null){
            return new ResponseEntity<>("SignUp Successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
