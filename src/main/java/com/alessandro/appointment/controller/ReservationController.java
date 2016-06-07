package com.alessandro.appointment.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alessandro.appointment.dao.AppointmentDAO;
import com.alessandro.appointment.dao.ReservationDAO;
import com.alessandro.appointment.dao.SlotDAO;
import com.alessandro.appointment.model.Appointment;
import com.alessandro.appointment.model.Reservation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/api/reservation")
public class ReservationController {
	
	@Autowired
	ReservationDAO reservationDAO; 
	
	@Autowired
	SlotDAO slotDAO;
	
	@RequestMapping(value = "/insert/{param}", method = RequestMethod.POST)
	@ResponseBody
	public void test(@RequestBody String reservation, @PathVariable int param) {
		try {
			Gson gson = new Gson();
			String app = URLDecoder.decode(reservation, "UTF-8");
			System.out.println("ciao "+ app);
			System.out.println("ciao "+ param);
			Reservation res = gson.fromJson(app.substring(12),  new TypeToken<Reservation>(){}.getType());
			reservationDAO.insert(res);
			
			System.out.println("res:"+res.getId()+" slot:"+param);
			slotDAO.update(res.getId(), param);
			
			
			
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
