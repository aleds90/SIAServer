package com.alessandro.appointment.model;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Reservation implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private String status;
	private Set slots = new HashSet(0);

	public Reservation() {
	}

	public Reservation(User user, String status, Set slots) {
		this.user = user;
		this.status = status;
		this.slots = slots;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@JsonBackReference
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@JsonBackReference
	public Set getSlots() {
		return this.slots;
	}

	public void setSlots(Set slots) {
		this.slots = slots;
	}

}