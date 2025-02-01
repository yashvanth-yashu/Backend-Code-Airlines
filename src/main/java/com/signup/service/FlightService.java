package com.signup.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.model.Flight;
import com.signup.repository.FlightRepository;

@Service
public class FlightService 
{
	@Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

	public List<Flight> getAllFlights() 
	{
		return flightRepository.findAll();
	}

	// New methods for update functionality
    public Optional<Flight> getFlightById(Long flightId) 
    {
        return flightRepository.findById(flightId); // Retrieve flight by ID
    }

    public Flight saveFlight(Flight flight) 
    {
        return flightRepository.save(flight); // Save or update the flight in the database
    }

	public void deleteFlight(Long flightId) 
	{
		 flightRepository.deleteById(flightId);		
	}

	public Optional<Flight> getFlightByFlightNo(String flightNo) 
	{
		return flightRepository.findByFlightNo(flightNo);
	}

}
