package com.cg.movieManagement.service;


import com.cg.movieManagement.exceptions.BookingException;
import com.cg.movieManagement.dto.BookingForm;

/************************************************************************************
 *          @author          Chaitanya Kumar
 *          Description      It is a service class that provides the services for  adding and cancelling a movie ticket 
  *         Version             1.0
  *         Created Date    17-APR-2020
 ************************************************************************************/
public interface MovieBookingService {
	
	
	public String addBooking(BookingForm bookingForm)throws BookingException;
	public boolean cancelBooking(String bookingId);
	}


