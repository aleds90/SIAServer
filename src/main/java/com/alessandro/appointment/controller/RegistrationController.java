package com.alessandro.appointment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alessandro.appointment.dao.UserDAO;
import com.alessandro.appointment.model.User;

/**
 * Description Classe che si occupa di tutte le chiamate inerenti alla registrazione di un nuovo utente.
 * @author Alessandro
 *
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	UserDAO userDAO;
	
		
	/**
	 * Description: si occupa della registrazione di un nuovo utente.
	 * @param utente da inserire.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public void list(@RequestBody User user) {
		userDAO.insert(user);

	}
	
}

