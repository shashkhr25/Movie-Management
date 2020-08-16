	package com.cg.movieManagement.dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cg.movieManagement.entities.Booking;
import com.cg.movieManagement.entities.Movie;
import com.cg.movieManagement.entities.Show;

/*************************************************************************************************************************
 * @author Shashwat khare 
 * Description : It is a dao implementation class, which has functionality of all of movie management functions and does the
 * 				transactions with entity classes. using entity manager.
 *         Version 1.0 
 *         Created Date 17-APR-2020
 *************************************************************************************************************************/
@Repository
public class MovieDaoImpl implements MovieDao{

	@PersistenceContext
	private EntityManager em;

/**************************************************************************************************
     *Method:     addmovie
     * @param movie: object of Movie type having details of movie to be added.
     *description:   Add the paticular record of movie class
     *@returns                 -return true
     *created by               -Madhan Mohan Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public boolean addMovie(Movie movie) {
		em.persist(movie);
		return true;
	}

	@Override
	public boolean editMovie(Movie movie) {
		em.merge(movie);
		return true;
	}

	@Override
	public Movie viewMovie(int movieId) {
		
		return em.find(Movie.class, movieId);
	}
	
/**************************************************************************************************
     *Method:    viewActiveMovies
     *description:   display all the records of movie which are active.
     *@returns                 -List of movies details
     *created by               -Madhan Mohan Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public List<Movie> viewActiveMovies() {
		String jpql = "from Movie m where m.active=1";
		TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
		
		return query.getResultList();
	}
	@Override
	public List<Show> getShows(int movieId) {
		String jpql = "from Show s inner join fetch s.movie m where m.movieId=:mid ";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		
		query.setParameter("mid", movieId);
		//query.setParameter("dt", LocalDate.now());
		return query.getResultList();
	}

	@Override
	public boolean editShow(Show show) {
		em.merge(show);
		return true;
	}

	@Override
	public boolean addBooking(Booking booking) {
		em.persist(booking);
		return true;
	}

	
	/*********************************************************************************************************************
	 * Method: getBookingDetails
	 * Description: To show the details of ticked booked by a certain using Contact Number as parameter.
	 * @param contact: contact used in the booking process
	 * Created By - Anand Raj 
	 * Created Date - 18-APR-2020
	 * @throws ShowException - When a show is search for a screen which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/
	@Override
	public List<Booking> getBookingDetailsContact(String contact) {
		String jpql = "from Booking b inner join fetch b.show s inner join fetch s.movie m where b.contact=:phone";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		
		query.setParameter("phone", contact);
		return query.getResultList();
	}

	@Override
	public Booking getBookingDetails(String bookingId) {
		String jpql = "from Booking b inner join fetch b.show s inner join fetch s.movie m where b.bookingId=:bid";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("bid", bookingId);
		return query.getSingleResult();
	}
	
	@Override
	public int countBookingInfo() {
		String jpql = "select count(bookingId) from Booking";
		TypedQuery<Integer> query = em.createQuery(jpql,Integer.class);
		return query.getSingleResult();
		
	}

	/*********************************************************************************************************************
	 * Method: getMovies 
	 * Description: To give a list of movies from database by taking movie name/movie director/ movie genre as input.
	 * @param searchStr: Movie's name/ movie genre/ movie director's name.
	 *              Created By - Shashwat khare 
	 *              Created Date - 17-APR-2020
	 *********************************************************************************************************************/
	@Override
	public List<Movie> getMovies(String searchStr) {
		String jpql = "from Movie m where m.movieName like :str or m.director like :str or m.language like :str or m.genre like :str";
		TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
		
		query.setParameter("str", searchStr);
		return query.getResultList();
	}

	@Override
	public Show getShow(int showId) {
		return em.find(Show.class, showId);
	}

	
	@Override
	public long getMaxBookingId(int showId) {
		String jpql = "select count(b.bookingId) from Booking b join b.show s where s.showId=:showid";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("showid", showId);
		return query.getSingleResult();
	}

	
	/*********************************************************************************************************************
	 * Method: getShows 
	 * Description: To give a list of shows from database by taking screen name as input.
	 * @param screenName: screen in which shows are to be searched.
	 *              Created By - Shashwat khare 
	 *              Created Date - 18-APR-2020
	 *********************************************************************************************************************/
	@Override
	public List<Show> getShows(String screenName) {
		String jpql = "from Show s inner join fetch s.movie m where s.screenName=:screenname and s.showDate >= :dt";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		
		query.setParameter("screenname", screenName);
		query.setParameter("dt", LocalDate.now());
		return query.getResultList();
	}

	@Override
	public List<Show> getShows() {
		String jpql = "from Show s inner join fetch s.movie m where  s.showDate >= :dt";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		query.setParameter("dt", LocalDate.now());
		return query.getResultList();
		
	}

	@Override
	public boolean removeBooking(Booking booking) {
		em.remove(booking);
		return true;
	}
}
