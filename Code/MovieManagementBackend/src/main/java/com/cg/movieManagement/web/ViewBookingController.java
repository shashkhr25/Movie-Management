package com.cg.movieManagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.movieManagement.entities.Booking;
import com.cg.movieManagement.exceptions.BookingException;
import com.cg.movieManagement.service.ViewBookingService;

/***************************************************************************************************************************
 * Description : It is Controller class for the project which handles request made (i.e Contact Number input) from the user
 * and redirects it to the Service class for the logical implementation.
 * @author Anand Raj
 * @version 1.0
 * @Created Date 17-APR-2020
 ***************************************************************************************************************************/
@RestController
public class ViewBookingController {

	@Autowired
	

	private ViewBookingService service;
	@CrossOrigin
	@GetMapping("getbooking/{contact}")    
	public List<Booking> getBookingDetails(@PathVariable("contact") String Contact) throws BookingException 
	{
		List<Booking> bookingDetails = service.getBookingDetails(Contact);
		return bookingDetails;          
	}
}
