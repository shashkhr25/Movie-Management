package com.cg.movieManagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.movieManagement.dto.BookingForm;
import com.cg.movieManagement.dto.MovieMessage;
import com.cg.movieManagement.exceptions.BookingException;
import com.cg.movieManagement.service.MovieBookingService;
import com.cg.movieManagement.util.MovieConstants;

/************************************************************************************
 *          @author          Chaitanya kumar
 *          Description      It is a service interface that provides the services for  
                                       Booking a movie ticket  
			
  *         Version             1.0
  *         Created Date    17-APR-2020
 ************************************************************************************/
@RestController
public class BookingMovieController {
	
	@Autowired
	private MovieBookingService service;
	
	/*********************************************************************************************************************************
	 * Method: AddBooking
     *Description: To add booking details using contact num showid and no.of tickets 
	 * @param name              - input of contact number showid and number of tickets.
	 * @returns       - 		BookingId
	 * @throws Booking exception - if number of tickets is less than required tickets 
                *Created By                              - Chaitanya kumar
                *Created Date                            - 18-APR-2020                           	 
	 **********************************************************************************************************************************/
	@CrossOrigin
	@PostMapping("/booking")
	public MovieMessage doBooking(@RequestBody BookingForm form) throws BookingException {
		String bookingId = service.addBooking(form);
		MovieMessage msg = new MovieMessage();
		msg.setMessage(bookingId);
		return msg;
	}
	
	
	/*********************************************************************************************************************************
	 * Method: CancelBooking
     *Description: To cancel booking  using bookingId
	 * @param name              - input bookingId
	 * @returns       - 		Alert message
	 * @throws Booking exception - if bookingid doesnt exist
                *Created By                              - Chaitanya kumar
                *Created Date                            - 17-APR-2020                           	 
	 **********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/cancelbooking/{bookingid}")
	public MovieMessage cancelBooking(@PathVariable(name="bookingid") String bookingId) throws BookingException {
		service.cancelBooking(bookingId);
		MovieMessage msg = new MovieMessage();
		msg.setMessage(MovieConstants.BOOKING_CANCELLED);
		return msg;
	}

}
