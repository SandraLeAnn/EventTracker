package com.skilldistillery.trips.services;

import java.util.List;

import com.skilldistillery.trips.entities.Expense;

public interface ExpenseService {
	List<Expense> allExpenses();
	Expense getExpenseById(int id);
	Expense create(Expense expense);
	Expense update(int id, Expense expense);
	boolean disableById(int id);
}
