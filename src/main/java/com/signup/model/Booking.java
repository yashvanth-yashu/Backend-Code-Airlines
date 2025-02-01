package com.signup.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bookings")
public class Booking 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
    private String passengerName;
    private String seatClass; // Economy, Business, First Class
    private String email;
    private int numberOfSeats;
    private double totalAmount;
    private Date bookingDate;
    private Time bookingTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Time getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}
	public Booking(Long id, Flight flight, String passengerName, String seatClass, String email, int numberOfSeats,
			double totalAmount, Date bookingDate, Time bookingTime) {
		super();
		this.id = id;
		this.flight = flight;
		this.passengerName = passengerName;
		this.seatClass = seatClass;
		this.email = email;
		this.numberOfSeats = numberOfSeats;
		this.totalAmount = totalAmount;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", flight=" + flight + ", passengerName=" + passengerName + ", seatClass="
				+ seatClass + ", email=" + email + ", numberOfSeats=" + numberOfSeats + ", totalAmount=" + totalAmount
				+ ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + "]";
	}

}
