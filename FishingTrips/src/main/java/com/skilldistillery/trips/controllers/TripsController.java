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

import com.skilldistillery.trips.entities.Trip;
import com.skilldistillery.trips.services.TripsServiceImpl;

@RestController
@RequestMapping
public class TripsController {
	
	@Autowired
	private TripsServiceImpl tripServ;
	
	@GetMapping("trips")
	public List<Trip> allTrips(){
		return tripServ.allTrips();
	}


	@GetMapping("trips/{id}")
	public Trip getTrip(@PathVariable Integer id, HttpServletResponse resp) {
		Trip trip = tripServ.getTripsById(id);
		if (trip == null) {
			resp.setStatus(404);
		}
		return trip;
	}
	
	@PostMapping("trips")
	public Trip createTrip(@RequestBody Trip trip, HttpServletResponse resp, HttpServletRequest req) {
		Trip newTrip = null;
		
		try {
			newTrip = tripServ.create(trip);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(trip.getId());
			resp.setHeader("Trip", url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return newTrip;
}

	@PutMapping("trip/{id}")
	public Trip updateTrip(@PathVariable("id") Integer tripId, @RequestBody Trip trip, HttpServletResponse resp) {
	Trip editTrip = null;
		
		try {
			editTrip = tripServ.update(tripId, trip);
			
			if (trip == null) {
				
				
				resp.setStatus(404);
			} 
		}catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(400);
				editTrip = null;
			}
		return editTrip;
		
	}
	
	@PutMapping("trip/delete/{id}")
	public boolean disableTrip(@PathVariable("id") Integer tripId, @RequestBody Trip trip, HttpServletResponse resp) {
		boolean deleted = false;
		try {
			deleted = tripServ.disableById(tripId);
			if (trip == null) {
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
