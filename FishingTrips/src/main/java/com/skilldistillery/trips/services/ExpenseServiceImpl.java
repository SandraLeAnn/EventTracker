package com.skilldistillery.trips.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.trips.entities.Expense;
import com.skilldistillery.trips.entities.Trip;
import com.skilldistillery.trips.repositories.ExpenseRepository;
import com.skilldistillery.trips.repositories.TripRepository;
@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ExpenseRepository expRepo;
	
	@Autowired
	private TripRepository tripRepo;
	
	@Override
	public List<Expense> allExpenses() {
		return expRepo.findAll();
	}

	@Override
	public List<Expense> findAllExpensesBytripId(int tripId) {
		List<Expense> tripExpenses= null;
		Trip currentTrip = null;
		Optional<Trip> tripOP = tripRepo.findById(tripId);

		if (tripId > 0) {
			if (tripOP.isPresent()) {
				currentTrip = tripOP.get();

				tripExpenses = currentTrip.getExpenses();
			}

		}
		return tripExpenses;
	}
	@Override
	public Expense getExpenseById(int id) {
		Optional<Expense> op = expRepo.findById(id);
		Expense expense = null;
		if (op.isPresent()) {
			expense = op.get();
			return expense;
		}
		return expense;
	}
	@Override
	public Expense create(Expense expense) {
		if (expense != null) {
			em.persist(expense);
		}
		return expense;
	}

	@Override
	public Expense update(int id, Expense expense) {
		
		Expense existing = getExpenseById(id);
		
		if (existing != null) {
			existing.setId(expense.getId());
			existing.setName(expense.getName());
			existing.setDescription(expense.getDescription());
			existing.setLocation(expense.getLocation());
			existing.setImage(expense.getImage());
			existing.setPrice(expense.getPrice());
			existing.setDate(expense.getDate());
			//existing.setUserId(trip.getUserId());
			em.flush();
			return existing;
		}
		return null;
	
	}

	@Override
	public boolean disableById(int id) {
		boolean deleted = false;

		Optional<Expense> op = expRepo.findById(id);
		Expense expense = null;
		if (op.isPresent()) {
			expense = op.get();
			Expense disableExpense = expense;
			
			if (disableExpense != null) {
				
				disableExpense.setActive(false);
				em.flush();
				deleted = true;
			}
		}
		return deleted;
	}
}

