package com.cg.movieManagement.service;

import java.util.List;

import com.cg.movieManagement.entities.Booking;
import com.cg.movieManagement.exceptions.BookingException;

/************************************************************************
 * @author Anand Raj
 * Description: This is the Service interface to show Booking Details functionality.
 * @version 1.0
 * @Created Date 17-APR-2020
 ************************************************************************/
public interface ViewBookingService {
	public List<Booking> getBookingDetails(String Contact)throws BookingException;
}
