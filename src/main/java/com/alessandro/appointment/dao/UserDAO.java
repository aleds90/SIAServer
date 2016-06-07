package com.alessandro.appointment.dao;

import java.util.List;

import com.alessandro.appointment.model.User;

public interface UserDAO {
	
	public User loadUserByUsername(String username);
	void insert(User user);
	List<User> getAll();
	List<User> getBySearch(String search);
	List<User> getRandomAnnouncement();

}
