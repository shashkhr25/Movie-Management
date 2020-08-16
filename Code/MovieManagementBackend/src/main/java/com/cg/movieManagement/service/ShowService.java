package com.cg.movieManagement.service;

import java.util.List;

import com.cg.movieManagement.dto.Screen;
import com.cg.movieManagement.entities.Show;
import com.cg.movieManagement.exceptions.ShowException;

/************************************************************************************
 *          @author          Gaurav Vasasali
 *          Description      It is a Show service interface that provides the services for viewing the shows  
                             and the screens of their respective movies.                            
 *          Version          2.0
 *          Created Date     28-APR-2020
************************************************************************************/

public interface ShowService {
	public List<Show> getShows(int movieId) throws ShowException ;
	public List<Screen> getScreens(int movieId)throws ShowException;
}
