package com.skilldistillery.trips.services;

import java.util.List;

import com.skilldistillery.trips.entities.User;


public interface UserService {
	
	List<User> allUsers();
	User getUserById(int id);
	User create(User user);
	User update(int id, User user);
	boolean disableById(int id);
}
