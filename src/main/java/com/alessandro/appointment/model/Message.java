package com.alessandro.appointment.model;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Message implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User userByReceiver;
	private User userBySender;
	private String text;
	private String date;

	public Message() {
	}

	public Message(User userByReceiver, User userBySender, String text, String date) {
		this.userByReceiver = userByReceiver;
		this.userBySender = userBySender;
		this.text = text;
		this.date = date;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonBackReference
	public User getUserByReceiver() {
		return this.userByReceiver;
	}

	public void setUserByReceiver(User userByReceiver) {
		this.userByReceiver = userByReceiver;
	}
	
	@JsonBackReference
	public User getUserBySender() {
		return this.userBySender;
	}

	public void setUserBySender(User userBySender) {
		this.userBySender = userBySender;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
