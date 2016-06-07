package com.alessandro.appointment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alessandro.appointment.dao.UserDAO;
import com.alessandro.appointment.model.User;



@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDAO userDAO;

	public User loadUserByUsername(String username){
		return userDAO.loadUserByUsername(username);
	}
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}

}

