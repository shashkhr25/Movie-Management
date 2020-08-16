package com.cg.movieManagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.movieManagement.entities.Movie;
import com.cg.movieManagement.exceptions.MovieNotFoundException;
import com.cg.movieManagement.service.ViewMovieService;


/************************************************************************************************************************
 *          @author          Madhan Mohan Reddy
 *          Description      It is a controller class, having functions which call service. 
  *         Version             1.0
  *         Created Date    19-APR-2020
 ************************************************************************************************************************/
@RestController
public class ViewMovieController {

	@Autowired
	private ViewMovieService service;
	
	/*********************************************************************************************************************************
	 * Method: viewmovies
     *Description: To give a list of movies in database. 
	 * @throws MovieNotFoundException 
	 * @returns List<Movie>       - all movies which are currently active.
                *Created By                              - Madhan Mohan Reddy
                *Created Date                            - 21-APR-2020                           	 
	 **********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/viewmovies")
	public List<Movie> viewMovies() throws MovieNotFoundException {		
		return service.viewMovies();
	}
	
	/*********************************************************************************************************************************
	 * Method: viewnewmovies
     *Description: To give a list of new movies in database. 
	 * @throws MovieNotFoundException 
	 * @returns List<Movie>       - all movies which are recently added and currently active.
                *Created By                              - Madhan Mohan Reddy
                *Created Date                            - 21-APR-2020                           	 
	 **********************************************************************************************************************************/
	@CrossOrigin
	@GetMapping("/viewnewmovies")
	public List<Movie> viewNewMovies() throws MovieNotFoundException {
		return service.viewNewMovies();
	}
}
