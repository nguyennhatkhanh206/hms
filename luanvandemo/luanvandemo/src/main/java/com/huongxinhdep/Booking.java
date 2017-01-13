package com.huongxinhdep;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="phong")
public class Booking {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
 private int id;

@NotNull
 private String hotelName;

@NotNull
 private double pricePerNight;

@NotNull
 private int numberOfNight;
 
 
public Booking() {
	super();
}
public Booking(String hotelName, double priceperNight, int numberOfNight) {
	super();
	this.hotelName = hotelName;
	this.pricePerNight = priceperNight;
	this.numberOfNight = numberOfNight;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public double getPriceperNight() {
	return pricePerNight;
}
public void setPriceperNight(double priceperNight) {
	this.pricePerNight = priceperNight;
}
public int getNumberOfNight() {
	return numberOfNight;
}
public void setNumberOfNight(int numberOfNight) {
	this.numberOfNight = numberOfNight;
}

public double gettotalPrice(){
	return pricePerNight*numberOfNight;
}
}
