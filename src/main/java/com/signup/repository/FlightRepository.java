package com.signup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signup.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>
{

	Optional<Flight> findByFlightNo(String flightNo);

}
