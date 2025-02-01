package com.signup.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Flight_Details")

public class Flight 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 	
 	@Column(name = "flight_no")
    private String flightNo;
    private String FlightName;
    private String Source;
    private String Destination;
    private String DepartureTime;
    private String ArrivalTime;
    private double Economy;
    private double FirstClass;
    private double Business;
    private String status;
    private String Action;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return FlightName;
	}
	public void setFlightName(String flightName) {
		FlightName = flightName;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}
	public String getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public double getEconomy() {
		return Economy;
	}
	public void setEconomy(double economy) {
		Economy = economy;
	}
	public double getFirstClass() {
		return FirstClass;
	}
	public void setFirstClass(double firstClass) {
		FirstClass = firstClass;
	}
	public double getBusiness() {
		return Business;
	}
	public void setBusiness(double business) {
		Business = business;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public Flight(Long id, String flightNo, String flightName, String source, String destination,
			String departureTime, String arrivalTime, double economy, double firstClass, double business,
			String status, String action) {
		super();
		this.id = id;
		this.flightNo = flightNo;
		FlightName = flightName;
		Source = source;
		Destination = destination;
		DepartureTime = departureTime;
		ArrivalTime = arrivalTime;
		Economy = economy;
		FirstClass = firstClass;
		Business = business;
		this.status = status;
		Action = action;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNo=" + flightNo + ", FlightName=" + FlightName + ", Source=" + Source
				+ ", Destination=" + Destination + ", DepartureTime=" + DepartureTime + ", ArrivalTime="
				+ ArrivalTime + ", Economy=" + Economy + ", FirstClass=" + FirstClass + ", Business=" + Business
				+ ", status=" + status + ", Action=" + Action + "]";
	}
	

}
