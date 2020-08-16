package com.cg.movieManagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movieManagement.dao.MovieDao;
import com.cg.movieManagement.entities.Movie;
import com.cg.movieManagement.entities.Show;
import com.cg.movieManagement.exceptions.MovieNotFoundException;
import com.cg.movieManagement.exceptions.ShowException;
import com.cg.movieManagement.util.MovieConstants;


/*************************************************************************************************************************
 * @author Shashwat khare 
 * Description It is a service class that provides the
 *         services for searching movies by entering movie name, movie genre,
 *         and movie director. And service for searching shows based on date, movie id, screen name.
 *         Version 1.0 
 *         Created Date 17-APR-2020
 *************************************************************************************************************************/

@Transactional
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private MovieDao dao;

	/*********************************************************************************************************************
	 * Method: getMovies 
	 * Description: To give a list of movies by taking movie name/movie director/ movie genre as input.
	 * @param searchStr: Movie's name/ movie genre/ movie director's name.
	 *              Created By - Shashwat khare 
	 *              Created Date - 17-APR-2020
	 * @throws MovieNotFoundException - When a movie is search for which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/
	@Override
	public List<Movie> getMovies(String searchStr) throws MovieNotFoundException {
		List<Movie> movieLst = dao.getMovies(searchStr);
		if(movieLst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		List<Movie> lst = movieLst.stream().filter(m->m.getActive()==MovieConstants.ACTIVE).sorted((m1,m2)->m1.getMovieName().compareTo(m2.getMovieName())).collect(Collectors.toList());
		return lst;
	}

	/*********************************************************************************************************************
	 * Method: getShows 
	 * Description: To give a list of shows by taking screen name as input.
	 * @param screenName: screen in which shows are to be searched.
	 *              Created By - Shashwat khare 
	 *              Created Date - 17-APR-2020
	 * @throws ShowException - When a show is search for a screen which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/
	@Override
	public List<Show> getShows(String screenName) throws ShowException {
		List<Show> showList = dao.getShows(screenName);
		
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		showList.sort((s1,s2)->s1.getScreenName().compareTo(s2.getScreenName()));
		return showList;
	}

	/*********************************************************************************************************************
	 * Method: getShows 
	 * Description: To give a list of shows by taking searchDt and movie id as input.
	 * @param searchDt: date in which shows are to be searched.
	 * @param movieId: movie id for which shows are to be searched.
	 *              Created By - Shashwat khare 
	 *              Created Date - 18-APR-2020
	 * @throws ShowException - When a show is search for a screen which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/
	@Override
	public List<Show> getShows(LocalDate searchDt, int movieId) throws ShowException {
		List<Show> showList = dao.getShows(movieId).stream().filter(s->s.getShowDate().equals(searchDt)).collect(Collectors.toList());
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		return showList;
	}

	
	/*********************************************************************************************************************
	 * Method: getShows 
	 * Description: To give a list of shows by taking searchDt and movie id and screen name as input.
	 * @param screenName: screen name in which shows are to be searched.
	 * @param searchDt: date in which shows are to be searched.
	 * @param movieId: movie id for which shows are to be searched.
	 *              Created By - Shashwat khare 
	 *              Created Date - 18-APR-2020
	 * @throws ShowException - When a show is search for a screen which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/
	@Override
	public List<Show> getShows(String screenName, LocalDate searchDt, int movieId) throws ShowException {
		List<Show> showList = dao.getShows(movieId).stream().filter(s->s.getShowDate().equals(searchDt) && s.getScreenName().contentEquals(screenName)).collect(Collectors.toList());
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		return showList;
	}

	/*********************************************************************************************************************
	 * Method: getShows 
	 * Description: To give a list of shows by taking searchDt and screen name as input.
	 * @param screenName: screen name in which shows are to be searched.
	 * @param searchDt: date in which shows are to be searched.
	 *              Created By - Shashwat khare 
	 *              Created Date - 18-APR-2020
	 * @throws ShowException - When a show is search for a screen which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/

	@Override
	public List<Show> getShows(String screenName, LocalDate searchDt) throws ShowException {
		List<Show> showList = dao.getShows().stream().filter(s->s.getShowDate().equals(searchDt) && s.getScreenName().contentEquals(screenName)).collect(Collectors.toList());
		if(showList.isEmpty())
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		return showList;
	}
}
