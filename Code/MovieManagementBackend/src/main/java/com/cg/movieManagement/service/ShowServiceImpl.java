package com.cg.movieManagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.movieManagement.dao.MovieDao;
import com.cg.movieManagement.dto.Screen;
import com.cg.movieManagement.entities.Show;
import com.cg.movieManagement.exceptions.ShowException;
import com.cg.movieManagement.util.MovieConstants;

/************************************************************************************
 *          @author          Gaurav Vasasali
 *          Description      It is a Show service class that provides the services for  getting 
 							 the shows and the screens of a particular movie.
 *          Version          2.0
 *          Created Date     18-APR-2020
 ************************************************************************************/
@Transactional
@Service
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	private MovieDao dao;
	
	
	
	/************************************************************************************
	 *          Method: getShows(movieId)
	 *          Description: To get all the shows for a particular movie to book the tickets.	
	 *          @param movieId            - movieId for the show
	 *          @returns Shows List      - It returns all the shows for the active movies. 
	 *          Created By                - Gaurav Vasasali
	 *          Created Date              - 18-APR-2020                           
	 ************************************************************************************/
	@Override
	public List<Show> getShows(int movieId) throws ShowException {
		List<Show> showList=dao.getShows(movieId);
		if(showList.isEmpty())
		{
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		}
		showList = showList.stream().filter(show->show.getShowDate().isAfter(LocalDate.now())).collect(Collectors.toList());
		showList.sort((s1,s2)->s2.getShowDate().compareTo(s1.getShowDate()));
			return showList;	
	}
	
	
	/************************************************************************************
	 *          Method: getScreens(movieId)
     *          Description: To all the screens for a particular movie to book tickets.	
     *          @param movieId            - movieId for the screen
     *          @returns Screens List      - It returns all the screens for the active movies.
     *          Created By                - Gaurav Vasasali
     *          Created Date              - 18-APR-2020                          
	 ************************************************************************************/
	@Override
	public List<Screen> getScreens(int movieId) throws ShowException {
		List<Show> showList=dao.getShows(movieId);
		if(showList.isEmpty())
		{
			throw new ShowException(MovieConstants.SCREEN_NOT_AVAILABLE);
		}
		showList = showList.stream().filter(show->show.getShowDate().isAfter(LocalDate.now())).collect(Collectors.toList());
		showList.sort((s1, s2)->s1.getScreenName().compareTo(s2.getScreenName()));
		String tmp = MovieConstants.EMPTY;
		
		Screen screen=null;
		List<Screen> screenList = new ArrayList<>();
		for(Show show: showList) {
			
			if(tmp.equalsIgnoreCase(show.getScreenName())) {
				screen.setShowNames(screen.getShowNames() + ", " + show.getScreenName());
			}else {
				screen = new Screen();
				screen.setMovie(show.getMovie());
				screen.setScreenName(show.getScreenName());
				screen.setScreenImg(show.getScreenImg());
				screen.setShowNames(show.getShowName());
				screen.setShowDate(show.getShowDate());
				screenList.add(screen);
			}
		}	
		return screenList;
	}
}
