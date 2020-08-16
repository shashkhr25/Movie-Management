package com.cg.movieManagement.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*************************************************************************************************************************
 *          @author          Shashwat khare
 *          Description      It is an entity class of Booking, which maps to a database table lpu_movie_booking, consists
 *          				 of its private data members, setters and getters.
 *         Version             1.0
 *         Created Date    17-APR-2020
 *************************************************************************************************************************/

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="lpu_movie_booking")
public class Booking {
	
	@Id
	@Column(name="booking_id")
	private String bookingId;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@Column(name="no_of_tkts")
	private int noOfTkts;
	
	@Column(name="total_cost")
	private double totalCost;
	
	@Column(name="user_name", length=25)
	private String userName;
	
	@Column(name="contact", length=10)
	private String contact;
	
	@ManyToOne
	@JoinColumn(name="show_id", referencedColumnName = "show_id")
	private Show show = new Show();

	
	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfTkts() {
		return noOfTkts;
	}

	public void setNoOfTkts(int noOfTkts) {
		this.noOfTkts = noOfTkts;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	
	
	
	
	}

