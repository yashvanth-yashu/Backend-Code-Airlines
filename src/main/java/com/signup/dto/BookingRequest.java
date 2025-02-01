package com.signup.dto;
import com.signup.model.Flight;
public class BookingRequest 
{
	private Flight flight;
    private String passengerName;
    private String email;
    private String seatClass;
    private int numberOfSeats;
    private double totalAmount;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
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
	public BookingRequest(Flight flight, String passengerName, String email, String seatClass, int numberOfSeats,
			double totalAmount) {
		super();
		this.flight = flight;
		this.passengerName = passengerName;
		this.email = email;
		this.seatClass = seatClass;
		this.numberOfSeats = numberOfSeats;
		this.totalAmount = totalAmount;
	}
	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookingRequest [flight=" + flight + ", passengerName=" + passengerName + ", email=" + email
				+ ", seatClass=" + seatClass + ", numberOfSeats=" + numberOfSeats + ", totalAmount=" + totalAmount
				+ "]";
	}

}
