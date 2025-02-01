package com.signup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signup.model.Booking;
import com.signup.model.Flight;
import com.signup.repository.BookingRepository;
import com.signup.service.FlightService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController 
{
	@Autowired
    private FlightService flightService;
    // Add a new flight
    @PostMapping("/addFlight")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.addFlight(flight);
        return ResponseEntity.ok(newFlight);
    }

    // Get all flights
    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    // Update flight details
    @PutMapping("/updateFlight/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable("flightId") Long flightId, @RequestBody Flight updatedFlight) {
        Optional<Flight> existingFlightOpt = flightService.getFlightById(flightId);

        if (existingFlightOpt.isPresent()) {
            Flight existingFlight = existingFlightOpt.get();
            existingFlight.setFlightNo(updatedFlight.getFlightNo());
            existingFlight.setFlightName(updatedFlight.getFlightName());
            existingFlight.setSource(updatedFlight.getSource());
            existingFlight.setDestination(updatedFlight.getDestination());
            existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
            existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
            existingFlight.setEconomy(updatedFlight.getEconomy());
            existingFlight.setBusiness(updatedFlight.getBusiness());
            existingFlight.setFirstClass(updatedFlight.getFirstClass());
            existingFlight.setStatus(updatedFlight.getStatus());
            Flight savedFlight = flightService.saveFlight(existingFlight);
            return ResponseEntity.ok(savedFlight);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Get a flight by ID
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("flightId") Long flightId) {
        Optional<Flight> flight = flightService.getFlightById(flightId);
        return flight.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Delete a flight by ID
    @DeleteMapping("/deleteFlight/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") Long flightId) {
        try {
            Optional<Flight> flightOpt = flightService.getFlightById(flightId);
            if (flightOpt.isPresent()) {
                flightService.deleteFlight(flightId);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get flight details by flight number
    @GetMapping("/flightDetails/{flightNo}")
    public ResponseEntity<Flight> getFlightByFlightNo(@PathVariable("flightNo") String flightNo) {
        Optional<Flight> flightOpt = flightService.getFlightByFlightNo(flightNo);
        return flightOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
