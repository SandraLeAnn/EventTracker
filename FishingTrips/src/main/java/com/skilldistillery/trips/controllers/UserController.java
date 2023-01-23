package com.skilldistillery.trips.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.trips.entities.User;
import com.skilldistillery.trips.services.UserServiceImpl;


@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserServiceImpl userServ;
	
	@GetMapping("user")
	public List<User> allUsers(){
		return userServ.allUsers();
	}


	@GetMapping("user/{id}")
	public User getUser(@PathVariable Integer id, HttpServletResponse resp) {
		User user = userServ.getUserById(id);
		if (user == null) {
			resp.setStatus(404);
		}
		return user;
	}
	
	@PostMapping("user")
	public User createUser(@RequestBody User user, HttpServletResponse resp, HttpServletRequest req) {
		User newUser = null;
		
		try {
			newUser = userServ.create(user);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(user.getId());
			resp.setHeader("user", url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return newUser;
}

	@PutMapping("user/{id}")
	public User updateUser(@PathVariable("id") Integer userId, @RequestBody User user, HttpServletResponse resp) {
		User editUser = null;
		
		try {
			editUser = userServ.update(userId, user);
			
			if (user == null) {
				resp.setStatus(404);
			} 
		}catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(400);
				editUser = null;
			}
		return editUser;
		
	}
	
	@PutMapping("user/delete/{id}")
	public boolean disableUser(@PathVariable("id") Integer userId, @RequestBody User user, HttpServletResponse resp) {
		boolean deleted = false;
		try {
			deleted = userServ.disableById(userId);
			if (user == null) {
				resp.setStatus(404);
				return deleted;
			} 
		}catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(400);
			}
		return deleted;
}
}