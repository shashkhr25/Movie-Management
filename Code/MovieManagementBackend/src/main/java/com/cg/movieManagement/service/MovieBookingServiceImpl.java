package com.cg.movieManagement.service;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.movieManagement.dao.MovieDao;
import com.cg.movieManagement.dto.BookingForm;
import com.cg.movieManagement.entities.Booking;
import com.cg.movieManagement.entities.Show;
import com.cg.movieManagement.exceptions.BookingException;
import com.cg.movieManagement.util.MovieConstants;

/*********************************************************************************************************************************
 * Method: AddBooking
 *Description: To add booking details using contact num showid and no.of tickets 
 * @param name              - input of contact number showid and number of tickets.
 * @returns       - 		BookingId
 * @throws Booking exception - if number of tickets is less than required tickets 
            *Created By                              - Chaitanya kumar
            *Created Date                            - 17-APR-2020                           	 
 **********************************************************************************************************************************/
@Transactional
@Service
public class MovieBookingServiceImpl implements MovieBookingService {

	@Autowired
	private MovieDao dao;

	/*********************************************************************************************************************************
	 * Method: AddBooking
     *Description: To add booking details using contact num showid and no.of tickets 
	 * @param name              - input of contact number showid and number of tickets.
	 * @returns       - 		BookingId
	 * @throws Booking exception - if number of tickets is less than required tickets 
                *Created By                              - Chaitanya kumar
                *Created Date                            - 18-APR-2020                           	 
	 **********************************************************************************************************************************/
	@Override
	public String addBooking(BookingForm bookingForm) throws BookingException {
		Show show = dao.getShow(bookingForm.getShowId());
		long bid =dao.getMaxBookingId(bookingForm.getShowId()) +1;
		if (show.getSeats() >= bookingForm.getTkts()) {
			String id= ""+show.getShowId()+""+bid;
			double cost= 250* bookingForm.getTkts();
			Booking booking = new Booking();
			booking.setBookingId(id);
			booking.setContact(bookingForm.getContact());
			booking.setUserName(bookingForm.getUserName());
			booking.setNoOfTkts(bookingForm.getTkts());
			booking.setBookingDate(LocalDate.now());
			booking.setTotalCost(cost);
			booking.setShow(show);
			show.setSeats(show.getSeats() - bookingForm.getTkts());
			dao.editShow(show);
			dao.addBooking(booking);
			return id;
		}
		throw new BookingException(MovieConstants.TKT_NOT_AVAILABLE);

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
	@Override
	public boolean cancelBooking(String bookingId) {
		Booking booking = dao.getBookingDetails(bookingId);
		Show show = booking.getShow();
		show.setSeats(show.getSeats() + booking.getNoOfTkts());
		dao.editShow(show);
		dao.removeBooking(booking);
		return true;
	}	
}
