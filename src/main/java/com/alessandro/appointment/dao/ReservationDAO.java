package com.alessandro.appointment.dao;

import java.util.List;

import com.alessandro.appointment.model.Reservation;



public interface ReservationDAO {
	
	void insert(Reservation reservation);
	List<Reservation> getAll();


}
