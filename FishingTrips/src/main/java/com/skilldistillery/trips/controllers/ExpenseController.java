package com.skilldistillery.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.trips.services.ExpenseService;


@RestController
@RequestMapping
public class ExpenseController {

	@Autowired
	private ExpenseService exp;
}
