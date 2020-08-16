package com.cg.movieManagement.dto;

public class BookingForm {

	private int showId;
	private int tkts;
	private String userName;
	private String contact;
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getTkts() {
		return tkts;
	}
	public void setTkts(int tkts) {
		this.tkts = tkts;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
