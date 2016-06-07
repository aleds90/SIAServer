package com.alessandro.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alessandro.appointment.dao.AppointmentDAO;
import com.alessandro.appointment.dao.SlotDAO;
import com.alessandro.appointment.model.Appointment;
import com.alessandro.appointment.model.Slot;

@Controller
@RequestMapping("/api/slot")
public class SlotController {
	
	@Autowired
	SlotDAO slotDAO; 
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Slot> getAll() {
		return slotDAO.getAll();

	}
	
	@RequestMapping(value = "byAppointment/{param}", method = RequestMethod.GET)
	@ResponseBody
	public List<Slot> getAllByAppointment(@PathVariable int param)  {
		return slotDAO.getAllByAppointment(param);

	}
	
	@RequestMapping(value = "byUser/{param}", method = RequestMethod.GET)
	@ResponseBody
	public List<Slot> getAllByUser(@PathVariable int param)  {
		return slotDAO.getAllByUser(param);

	}
	
}
