package com.skilldistillery.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.trips.services.UserService;


@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService user;
}
