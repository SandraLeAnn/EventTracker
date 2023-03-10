package com.skilldistillery.trips.services;

import java.util.List;

import com.skilldistillery.trips.entities.Expense;

public interface ExpenseService {
	List<Expense> allExpenses();
	List<Expense> findAllExpensesBytripId(int tripId);
	Expense getExpenseById(int id);
	Expense create(Expense expense, int tripId);
	Expense update(int id, Expense expense);
	boolean disableById(int id);
}
