package com.skilldistillery.trips.services;

import java.util.List;

import com.skilldistillery.trips.entities.trips;

public interface TripsService {
	List<trips> allTrips();
	trips getTrips(int id);
	trips create(trips name);
	trips update(int id, trips name);
	boolean deleteById(int id);
}
