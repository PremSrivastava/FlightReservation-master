package com.flightReservation.repository;

import com.flightReservation.entity.FlightUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightUserRepository extends JpaRepository<FlightUser, Long> {

     Optional<FlightUser> findUserByUsername(String username);
}