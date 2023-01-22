package com.skilldistillery.trips.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.trips.entities.Trip;
import com.skilldistillery.trips.repositories.TripRepository;
@Service
@Transactional
public class TripsServiceImpl implements TripsService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private TripRepository tripsRepo;
	@Override
	public List<Trip> allTrips() {
		return tripsRepo.findAll();
	}

	@Override
	public Trip getTripsById(int id) {
		return em.find(Trip.class, id);
	}

	@Override
	public Trip create(Trip trip) {
		if (trip != null) {
		}
			em.persist(trip);
		return trip;
	}

	@Override
	public Trip update(int id, Trip trip) {
		
		Trip existing = em.find(Trip.class, id);
		if (existing != null) {
			existing.setId(trip.getId());
			existing.setName(trip.getName());
			existing.setDescription(trip.getDescription());
			existing.setLocation(trip.getLocation());
			existing.setImage(trip.getImage());
			existing.setTotalPrice(trip.getTotalPrice());
			existing.setStartDate(trip.getStartDate());
			existing.setEndDate(trip.getEndDate());
			//existing.setUserId(trip.getUserId());
			em.flush();
			return existing;
		}
		return null;
	
	}

	@Override
	public boolean disableById(int id) {
		boolean deleted = false;
		Trip toDelete = em.find(Trip.class, id);
		if (toDelete != null) {
			em.remove(toDelete);
			deleted = true;
		}
		return deleted;
	}
}
