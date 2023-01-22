package com.skilldistillery.trips.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.trips.entities.Expense;
import com.skilldistillery.trips.repositories.ExpenseRepository;
@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ExpenseRepository expRepo;
	
	@Override
	public List<Expense> allExpenses() {
		return expRepo.findAll();
	}

	@Override
	public Expense getExpenseById(int id) {
		return em.find(Expense.class, id);
	}

	@Override
	public Expense create(Expense expense) {
		if (expense != null) {
		}
			em.persist(expense);
		return expense;
	}

	@Override
	public Expense update(int id, Expense expense) {
		
		Expense existing = em.find(Expense.class, id);
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
		Expense toDelete = em.find(Expense.class, id);
		if (toDelete != null) {
			em.remove(toDelete);
			deleted = true;
		}
		return deleted;
	}
}

