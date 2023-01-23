package com.skilldistillery.trips.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.trips.entities.User;
import com.skilldistillery.trips.repositories.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public List<User> allUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		Optional<User> op = userRepo.findById(id);
		User user = null;
		if (op.isPresent()) {
			user = op.get();
			return user;
		}
		return user;
	}
	@Override
	public User create(User user) {
		if (user != null) {
			em.persist(user);
		}
		return user;
	}

	@Override
	public User update(int id, User user) {
		
		User existing = getUserById(id);
		
		if (existing != null) {
			existing.setId(user.getId());
			existing.setFirstName(user.getFirstName());
			existing.setLastName(user.getLastName());
			existing.setUsername(user.getUsername());
			existing.setPassword(user.getPassword());
			existing.setImage(user.getImage());
			existing.setRole(user.getRole());
			existing.setActive(user.isActive());
			existing.setEmail(user.getEmail());
			em.flush();
			return existing;
		}
		return null;
	
	}
	@Override
	public boolean disableById(int id) {
		boolean deleted = false;

		Optional<User> op = userRepo.findById(id);
		User user = null;
		if (op.isPresent()) {
			user = op.get();
			User disableUser = user;
			
			if (disableUser != null) {
				disableUser.setActive(false);
				em.flush();
				deleted = true;
			}
		}
		return deleted;

	}
}
