package com.signup.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.model.Booking;
import com.signup.repository.BookingRepository;
@Service
public class BookingService 
{
	 @Autowired
	    private BookingRepository bookingRepository;

	    public Booking addBooking(Booking booking) {
	        return bookingRepository.save(booking);
	    }

	    public List<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }
}
