package com.cg.movieManagement.dto;

import java.time.LocalDate;

import com.cg.movieManagement.entities.Movie;

public class Screen {

	private Movie movie;
	private String screenName;
	private String screenImg;
	private String showNames;
	private LocalDate showDate;
	
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getShowNames() {
		return showNames;
	}
	public void setShowNames(String showNames) {
		this.showNames = showNames;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getScreenImg() {
		return screenImg;
	}
	public void setScreenImg(String screenImg) {
		this.screenImg = screenImg;
	}
	
	
}
