package com.cg.movieManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movieManagement.dao.MovieDao;
import com.cg.movieManagement.entities.Movie;
import com.cg.movieManagement.exceptions.MovieNotFoundException;
import com.cg.movieManagement.util.MovieConstants;

/*************************************************************************************************************************
 * @author Madan mohan reddy 
 * Description It is a service class for view movie functionality.
 *         Version 1.0 
 *         Created Date 21-APR-2020
 *************************************************************************************************************************/
@Transactional
@Service
public class ViewMovieServiceImpl implements ViewMovieService{

	@Autowired
	private MovieDao dao;
	
	
	/*********************************************************************************************************************
	 * Method: viewMovies 
	 * Description: To give a list of movies active in database.
	 *              Created By - Madan mohan reddy 
	 *              Created Date - 21-APR-2020
	 * @throws MovieNotFoundException 
	 *********************************************************************************************************************/
	@Override
	public List<Movie> viewMovies() throws MovieNotFoundException {
		List<Movie> movielst = dao.viewActiveMovies();
		if(movielst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		movielst.sort((m1,m2)->m1.getMovieName().compareTo(m2.getMovieName()));
		return movielst;
	}

	
	/*********************************************************************************************************************
	 * Method: viewNewMovies 
	 * Description: To give a list of new movies active in database.
	 *              Created By - Madan mohan reddy 
	 *              Created Date - 21-APR-2020
	 * @throws MovieNotFoundException 
	 *********************************************************************************************************************/
	@Override
	public List<Movie> viewNewMovies() throws MovieNotFoundException {
		List<Movie> movielst = dao.viewActiveMovies();
		if(movielst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		List<Movie> newMovies = new ArrayList<>();
		newMovies.addAll(getMovies(movielst, MovieConstants.ENGLISH));
		newMovies.addAll(getMovies(movielst, MovieConstants.HINDI));
		newMovies.addAll(getMovies(movielst, MovieConstants.TELUGU));
		return newMovies;
	}
	
	public List<Movie> getMovies(List<Movie> movielst, String language){
		return movielst.stream().filter(m->m.getLanguage().equalsIgnoreCase(language)).sorted((m1,m2)->m2.getReleaseDt().compareTo(m1.getReleaseDt()))
				.limit(2).collect(Collectors.toList());
	}

}
