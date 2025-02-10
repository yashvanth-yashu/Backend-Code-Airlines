package com.signup.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.signup.dto.BookingRequest;
import com.signup.exception.ResourceNotFoundException;
import com.signup.model.Booking;
import com.signup.model.Flight;
import com.signup.repository.BookingRepository;
import com.signup.repository.FlightRepository;
import com.signup.service.EmailService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController 
{
	@Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/addBooking")
    public List<Booking> addBooking(@RequestBody BookingRequest bookingRequest) {
        // Find the flight based on flight number
        Flight flight = flightRepository.findByFlightNo(bookingRequest.getFlight().getFlightNo())
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with flight number: " + bookingRequest.getFlight().getFlightNo()));

        // List to hold the individual booking records
        List<Booking> bookings = new ArrayList<>();

        // Loop through and create a booking for each seat
        for (int i = 0; i < bookingRequest.getNumberOfSeats(); i++) {
            // Create a new booking record for each seat
            Booking booking = new Booking();
            booking.setFlight(flight);
            booking.setPassengerName(bookingRequest.getPassengerName());
            booking.setEmail(bookingRequest.getEmail());
            booking.setSeatClass(bookingRequest.getSeatClass());
            booking.setTotalAmount(bookingRequest.getTotalAmount() / bookingRequest.getNumberOfSeats()); // Divide total amount by the number of seats
            booking.setBookingDate(new Date(System.currentTimeMillis())); // Set booking date

            // Save the booking
            bookings.add(bookingRepository.save(booking));  // Save individual bookings
        }

        // Send a booking confirmation email after booking is successfully saved
        Booking savedBooking = bookings.get(0);  // Assuming the email will be the same for all bookings
        String subject = "Booking Confirmation";
        String message = "Dear " + savedBooking.getPassengerName() + ",\n\n" +
                         "Your booking has been successfully confirmed for flight " + savedBooking.getFlight().getFlightNo() + ".\n" + "\n "+
                         "Seat Class: " + savedBooking.getSeatClass() + "\n" +
                         "Total Amount: ₹ " + savedBooking.getTotalAmount() + "\n" + "\n "+
                         "Thank you for choosing us, Happy Journey ✈️✈️!" +"\n "+
                         "Best regards "+"\n " +
                         "Yashvanth_Donthula";
        
        try {
            emailService.sendBookingConfirmation(savedBooking.getEmail(), subject, message);  // Send email
        } catch (Exception e) {
            e.printStackTrace();
            return bookings;  // Return the list of bookings even if email sending failed
        }

        return bookings;  // Return the list of bookings (for confirmation)
    }

    // Fetch bookings based on email
    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getBookingsByEmail(@RequestParam("email") String email) {
        List<Booking> bookings = bookingRepository.findByEmail(email); // Filter bookings by email
        if (bookings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookings); // No bookings found
        }
        return ResponseEntity.ok(bookings); // Return bookings for the logged-in user
    }

}
