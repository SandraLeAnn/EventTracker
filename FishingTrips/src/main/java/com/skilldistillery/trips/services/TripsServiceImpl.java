package com.skilldistillery.trips.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.trips.entities.trips;
import com.skilldistillery.trips.repositories.TripsRepository;
@Service
public class TripsServiceImpl implements TripsService {
	@Autowired
	private TripsRepository tripsRepo;
	@Override
	public List<trips> allTrips() {
		// TODO Auto-generated method stub
		return tripsRepo.findAll();
	}

	@Override
	public trips getTrips(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public trips create(trips name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public trips update(int id, trips name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
