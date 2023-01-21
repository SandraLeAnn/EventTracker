package com.skilldistillery.trips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.trips.entities.trips;
import com.skilldistillery.trips.services.TripsService;

@RestController
@RequestMapping
public class TripsController {
	@Autowired
	private TripsService tripsSer;
	
	@GetMapping("trips")
	public List<trips> allTrips(){
		return tripsSer.allTrips();
	}
	

}
