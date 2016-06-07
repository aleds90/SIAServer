package com.alessandro.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alessandro.appointment.dao.UserDAO;
import com.alessandro.appointment.model.User;

/**
 * Description Classe che si occupa di tutte le chiamate inerenti alla entity User.
 * @param Ogni chiamata necessita' di un "Access Token" attivo.
 * @author Alessandro
 *
 */
@Controller
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	
	/**
	 * 
	 * @return lista di tutti gli utenti presenti in db.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAll() {
		return userDAO.getAll();

	}
	
	/**
	 * 
	 * @param parametro di ricerca
	 * @return lista degli utenti utenti selezionata in base al parametro passato.
	 */
	@RequestMapping(value = "/{param}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> searchByParam(@PathVariable String param)  {
		return userDAO.getBySearch(param);

	}
	
	/**
	 * 
	 * @return lista di tutti i professionisti presenti in db.
	 */
	@RequestMapping(value = "/getAllProfessionist", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllProfessionist()  {
	
		return userDAO.getRandomAnnouncement();
	}
	
	/**
	 * 
	 * @return utente proprietario del token.
	 */
	@RequestMapping(value = "/getLoggedUser", method = RequestMethod.GET)
	@ResponseBody
	private User getLoggedUser() {
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String username;
		 if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		 } else {
		   username = principal.toString();
		 }
		 System.out.println("l username loggato: "+username);
		 User user = userDAO.loadUserByUsername(username);
		 return user;
	}
}
