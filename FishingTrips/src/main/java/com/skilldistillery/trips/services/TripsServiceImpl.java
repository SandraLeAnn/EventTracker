package com.skilldistillery.trips.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.trips.entities.Trip;
import com.skilldistillery.trips.entities.User;
import com.skilldistillery.trips.repositories.TripRepository;
import com.skilldistillery.trips.repositories.UserRepository;

@Service
@Transactional
public class TripsServiceImpl implements TripsService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private TripRepository tripsRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Trip> allTrips() {
		return tripsRepo.findAll();
	}

	@Override
	public List<Trip> allTripsByUser(User user) {
		List<Trip> usersTrips = null;
		User currentUser = null;
		Optional<User> userOP = userRepo.findById(user.getId());

		if (user != null) {
			if (userOP.isPresent()) {
				currentUser = userOP.get();

			 usersTrips = currentUser.getTrips();
			}

		}
		return usersTrips;
//		return tripsRepo.findAll();
	}

	@Override
	public Trip getTripsById(int id) {
		Optional<Trip> op = tripsRepo.findById(id);
		Trip trip = null;
		if (op.isPresent()) {
			trip = op.get();
			return trip;
		}
		return trip;
	}

	
	
	@Override
	public Trip create(Trip trip, int userId) {
		
		Optional<User> userOP = userRepo.findById(userId);
		User user = null;
		if(userOP.isPresent()) {
			user = userOP.get();
			if (trip != null) {
				trip.setUser(user);
				em.persist(trip);
				
				
				
		if (trip != null) {
			em.persist(trip);
		}
			}
		}
		return trip;
	}

	@Override
	public Trip update(int id, Trip trip) {

		Trip existing = getTripsById(id);

		if (existing != null) {
			existing.setId(trip.getId());
			existing.setName(trip.getName());
			existing.setDescription(trip.getDescription());
			existing.setLocation(trip.getLocation());
			existing.setImage(trip.getImage());
			existing.setTotalPrice(trip.getTotalPrice());
			existing.setStartDate(trip.getStartDate());
			existing.setEndDate(trip.getEndDate());
			existing.setActive(trip.isActive());
//			existing.setUser(trip.getUser());
			em.flush();
			return existing;
		}
		return null;

	}

	@Override
	public boolean disableById(int id) {
		boolean deleted = false;

		Optional<Trip> op = tripsRepo.findById(id);
		Trip trip = null;
		if (op.isPresent()) {
			trip = op.get();
			Trip disableTrip = trip;
			
			if (disableTrip != null) {
				disableTrip.setActive(false);
				em.flush();
				deleted = true;
			}
		}
		return deleted;

	}
}
