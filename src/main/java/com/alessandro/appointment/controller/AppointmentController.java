package com.alessandro.appointment.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alessandro.appointment.dao.AppointmentDAO;
import com.alessandro.appointment.dao.SlotDAO;
import com.alessandro.appointment.dao.UserDAO;
import com.alessandro.appointment.model.Appointment;
import com.alessandro.appointment.model.Slot;
import com.alessandro.appointment.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



@Controller
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentDAO appointmentDAO; 
	
	@Autowired
	SlotDAO slotDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Appointment> getAll() {
		return appointmentDAO.getAll();

	}
	
	@RequestMapping(value = "/{param}", method = RequestMethod.GET)
	@ResponseBody
	public List<Appointment> searchByParam(@PathVariable int param)  {
		return appointmentDAO.getAllByUser(param);

	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void insert(@RequestBody Appointment appointment) {
		
		  appointmentDAO.insert(appointment);
		  String result = "Record entered: "+ appointment;
		  
		  System.out.println(appointment.getDateStart());
		  System.out.println(appointment.getDateEnd());
		  
		  String format = "dd-MM-yyyy hh:mm:ss";
		  SimpleDateFormat sdf = new SimpleDateFormat(format);
		  
		  try {
			Date dateObj1 = sdf.parse(appointment.getDateStart());
			Date dateObj2 = sdf.parse(appointment.getDateEnd());

			long dif = dateObj1.getTime();
				while (dif < (dateObj2.getTime()- 1)) {
				    Date slot = new Date(dif);
				    
				    System.out.println("Hour Slot --->" + slot);
				    
				    Slot currentSlot = new Slot();
				    
				    currentSlot.setAppointment(appointment);
				    
				    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Set your date format
				    String currentDataStart = sdf1.format(slot); 
				    
				    currentSlot.setDataStart(currentDataStart);
				    
				    
				    dif += 3600000;
				    
				    Date slot1 = new Date(dif);
				    String currentDataEnd = sdf1.format(slot1); 
				    currentSlot.setDataEnd(currentDataEnd);
				    
				 
				    slotDAO.insert(currentSlot);     
				}

		  	} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@RequestMapping(value = "/insertTest", method = RequestMethod.POST)
	@ResponseBody
	public void test(@RequestBody String appointment) {
		try {
			Gson gson = new Gson();
			String app = URLDecoder.decode(appointment, "UTF-8");
			System.out.println("ciao "+ app);
			Appointment appointment1 = gson.fromJson(app.substring(12),  new TypeToken<Appointment>(){}.getType());
			appointmentDAO.insert(appointment1);
			  String format = "dd-MM-yyyy hh:mm:ss";
			  SimpleDateFormat sdf = new SimpleDateFormat(format);
			  
			  try {
				Date dateObj1 = sdf.parse(appointment1.getDateStart());
				Date dateObj2 = sdf.parse(appointment1.getDateEnd());

				long dif = dateObj1.getTime();
					while (dif < (dateObj2.getTime()- 1)) {
					    Date slot = new Date(dif);
					    
					    System.out.println("Hour Slot --->" + slot);
					    
					    Slot currentSlot = new Slot();
					    
					    currentSlot.setAppointment(appointment1);
					    
					    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Set your date format
					    String currentDataStart = sdf1.format(slot); 
					    
					    currentSlot.setDataStart(currentDataStart);
					    
					    
					    dif += 3600000;
					    
					    Date slot1 = new Date(dif);
					    String currentDataEnd = sdf1.format(slot1); 
					    currentSlot.setDataEnd(currentDataEnd);
					    
					 
					    slotDAO.insert(currentSlot);     
					}

			  	} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
//		     TrenitaliaBean[] list =  gson.fromJson(json.text(), TrenitaliaBean[].class);		     
//		     ArrayList<TrenitaliaBean> listaTrenitalia = new ArrayList<TrenitaliaBean>(Arrays.asList(list));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	

}
