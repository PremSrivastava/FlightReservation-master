package com.flightReservation.services;

import com.flightReservation.dto.FlightrUserDto;
import com.flightReservation.dto.LoginDto;
import com.flightReservation.entity.FlightUser;
import com.flightReservation.repository.FlightUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServcie {
    @Autowired
    private FlightUserRepository flightUserRepository;

    public FlightUser addFlightUser(FlightrUserDto flightrUserDto) {
        FlightUser flightUser = new FlightUser();
        flightUser.setFirstName(flightrUserDto.getFirstName());
        flightUser.setLastName(flightrUserDto.getLastName());
        flightUser.setEmail(flightrUserDto.getEmail());
        flightUser.setUserRole(flightrUserDto.getUserRole());
        flightUser.setMobile(flightrUserDto.getMobile());
        flightUser.setUsername(flightrUserDto.getUsername());
        flightUser.setPassword(BCrypt.hashpw(flightrUserDto.getPassword(),BCrypt.gensalt(10)));
        flightUserRepository.save(flightUser);

        return flightUser;

    }

    public String verifyUser(LoginDto loginDto) {

        Optional<FlightUser> userByUsername = flightUserRepository.findUserByUsername(loginDto.getUsername());
        if (userByUsername.isPresent()) {
            FlightUser flightUser = userByUsername.get();
            if (BCrypt.checkpw(loginDto.getPassword(), flightUser.getPassword())) {
                return flightUser.getUsername();
            }
        }
        return null;
//        FlightUser flightUser = flightUserRepository.findByUsername(loginDto.getUsername());
//        if (flightUser == null) {
//            return null;
//        }
//        if (BCrypt.checkpw(loginDto.getPassword(), flightUser.getPassword())) {
//            return flightUser.getUsername();
//        } else {
//            return null;
//        }

    }
}
