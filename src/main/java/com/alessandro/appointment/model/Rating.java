package com.alessandro.appointment.model;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Rating implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User userByUserReceiver;
	private User userByUserSender;
	private Integer rate;

	public Rating() {
	}

	public Rating(User userByUserReceiver, User userByUserSender, Integer rate) {
		this.userByUserReceiver = userByUserReceiver;
		this.userByUserSender = userByUserSender;
		this.rate = rate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonBackReference
	public User getUserByUserReceiver() {
		return this.userByUserReceiver;
	}

	public void setUserByUserReceiver(User userByUserReceiver) {
		this.userByUserReceiver = userByUserReceiver;
	}
	@JsonBackReference(value="rating-movement")
	public User getUserByUserSender() {
		return this.userByUserSender;
	}

	public void setUserByUserSender(User userByUserSender) {
		this.userByUserSender = userByUserSender;
	}

	public Integer getRate() {
		return this.rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

}