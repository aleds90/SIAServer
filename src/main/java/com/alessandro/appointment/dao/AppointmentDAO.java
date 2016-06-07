package com.alessandro.appointment.dao;

import java.util.List;

import com.alessandro.appointment.model.Appointment;



public interface AppointmentDAO {
	void insert(Appointment appointment);
	List<Appointment> getAll();
	List<Appointment> getAllByUser(int user);
	


}
