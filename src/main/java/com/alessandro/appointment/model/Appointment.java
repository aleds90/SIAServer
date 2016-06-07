package com.alessandro.appointment.model;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Appointment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private String dateStart;
	private String dateEnd;
	private String name;
	private String description;
	private Set slots = new HashSet(0);

	public Appointment() {
	}

	public Appointment(User user, String dateStart, String dateEnd, String name, String description, Set slots) {
		this.user = user;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.name = name;
		this.description = description;
		this.slots = slots;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@JsonBackReference(value="user-movement")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@JsonBackReference
	public Set getSlots() {
		return this.slots;
	}

	public void setSlots(Set slots) {
		this.slots = slots;
	}

}
