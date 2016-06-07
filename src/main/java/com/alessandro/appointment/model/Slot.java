package com.alessandro.appointment.model;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Slot implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Reservation reservation;
	private Appointment appointment;
	private String dataStart;
	private String dataEnd;

	public Slot() {
	}

	public Slot(Reservation reservation, Appointment appointment, String dataStart, String dataEnd) {
		this.reservation = reservation;
		this.appointment = appointment;
		this.dataStart = dataStart;
		this.dataEnd = dataEnd;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getDataStart() {
		return this.dataStart;
	}

	public void setDataStart(String dataStart) {
		this.dataStart = dataStart;
	}

	public String getDataEnd() {
		return this.dataEnd;
	}

	public void setDataEnd(String dataEnd) {
		this.dataEnd = dataEnd;
	}

}
