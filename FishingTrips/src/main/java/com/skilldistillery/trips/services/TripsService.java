package com.skilldistillery.trips.services;

import java.util.List;

import com.skilldistillery.trips.entities.Trip;
import com.skilldistillery.trips.entities.User;

public interface TripsService {
	List<Trip> allTrips();
	List<Trip> allTripsByUser(User user);
	Trip getTripsById(int id);
	Trip create(Trip name);
	Trip update(int id, Trip name);
	boolean disableById(int id);
}
