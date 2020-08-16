package com.cg.movieManagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.movieManagement.dto.Screen;
import com.cg.movieManagement.entities.Show;
import com.cg.movieManagement.exceptions.ShowException;
import com.cg.movieManagement.service.ShowService;

/**************************************************************************************************
 *          @author         Gaurav Vasasali
 *          Description      It is a controller class having Request Mapping functions
 *          				 for functionalities of search shows and search screens.
 *          Version             2.0
 *          Created Date    18-APR-2020
 **************************************************************************************************/
@RestController
public class ShowController {
	@Autowired
	ShowService movieservice;
	
	/*******************************************
	 * Method: getShows
     *Description: To view shows for a movie using movieId. 
	 * @param name              - input of /movieId.
	 * @returns shows(List<Show>)   - all shows will be displayed for that movieId.
	 * @throws ShowException - When that show does not exists in database, exception is thrown. 
                *Created By                              - Gaurav Vasasali
                *Created Date                            - 18-APR-2020                           	 
	 ********************************************/
	@CrossOrigin
	@GetMapping("/viewshows/{movieid}")
	public List<Show> getShows(@PathVariable("movieid") int movieId) throws ShowException
	{
		List<Show> shows = movieservice.getShows(movieId);
		return shows;
		
	}
	
	/*******************************************
	 * Method: getScreen
     *Description: To view screen for a movie using movieId. 
	 * @param name              - input of /movieId.
	 * @returns shows(List<Show>)   - all screens will be displayed for that movieId.
	 * @throws ShowException - When the screen does not exists in database, exception is thrown. 
                *Created By                              - Gaurav Vasasali
                *Created Date                            - 28-APR-2020                           	 
	 ********************************************/
	@CrossOrigin
	@GetMapping("/viewscreen/{movieid}")
	public List<Screen> getScreen(@PathVariable("movieid") int movieId) throws ShowException
	{
		List<Screen> screens = movieservice.getScreens(movieId);
		return screens;
		
	}
	
	
	
}
