package com.cg.movieManagement.service;

import java.util.List;

import com.cg.movieManagement.entities.Movie;
import com.cg.movieManagement.exceptions.MovieNotFoundException;

/*************************************************************************************************************************
 * @author Madan mohan reddy 
 * Description It is a service interface for view movie service.
 *         Version 1.0 
 *         Created Date 19-APR-2020
 *************************************************************************************************************************/
public interface ViewMovieService {

	public List<Movie> viewMovies() throws MovieNotFoundException;
	public List<Movie> viewNewMovies() throws MovieNotFoundException;
}
