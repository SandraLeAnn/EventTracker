package com.skilldistillery.trips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.trips.entities.Trip;
import com.skilldistillery.trips.services.TripsService;

@RestController
@RequestMapping
public class TripsController {
	
	@Autowired
	private TripsService trip;
	
	@GetMapping("trips")
	public List<Trip> allTrips(){
		return trip.allTrips();
	}
//	@GetMapping("trips/{id}")
//	public Trip getTrips(@PathVariable int id) {
//		Trip trip = tripsSer.getTrips(id);
//		if(trip == null)
//
//	return tripsSer.getTrips(id);	
//	}
	

}
