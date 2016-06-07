package com.alessandro.appointment.dao;

import java.util.List;

import com.alessandro.appointment.model.Slot;

public interface SlotDAO {
	void insert(Slot slot);
	List<Slot> getAll();
	List<Slot> getAllByUser(int user);
	List<Slot> getAllByAppointment(int appointment);
	void update(int reservation, int slot);
}
