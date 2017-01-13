package com.huongxinhdep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/bookings")
public class BookingController {

	BookingResposibility bookingrepository;
	
	@Autowired
	public BookingController(BookingResposibility bookingres)
	{
		
		this.bookingrepository=bookingres;
	}
	
	@RequestMapping(value="/getall", method=RequestMethod.GET)
	public List<Booking> getall()
	{
		return bookingrepository.findAll();
	}

	@RequestMapping(value="/getallprice/{price}", method=RequestMethod.GET)
	public List<Booking> getallprice(@PathVariable double price)
	{
		return bookingrepository.findByPricePerNightLessThan(price);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public List<Booking> create(@RequestBody Booking hotelBooking)
	{
		
		bookingrepository.save(hotelBooking);
		return bookingrepository.findAll();
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public List<Booking> remove(@PathVariable int id)
	{
		bookingrepository.delete(id);
		return bookingrepository.findAll();
		
	}
}
