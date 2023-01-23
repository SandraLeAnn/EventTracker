package com.skilldistillery.trips.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.trips.entities.Expense;
import com.skilldistillery.trips.services.ExpenseService;


@RestController
@RequestMapping
public class ExpenseController {

	@Autowired
	private ExpenseService exp;
	
	@GetMapping("expense")
	public List<Expense> allExpenses(){
		return exp.allExpenses();
	}


	@GetMapping("expense/{id}")
	public Expense getExpense(@PathVariable Integer id, HttpServletResponse resp) {
		Expense expense = exp.getExpenseById(id);
		if (expense == null) {
			resp.setStatus(404);
		}
		return expense;
	}
	
	@PostMapping("expense")
	public Expense createExpense(@RequestBody Expense expense, HttpServletResponse resp, HttpServletRequest req) {
		Expense newExpense= null;
		
		try {
			newExpense = exp.create(expense);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(expense.getId());
			resp.setHeader("expense", url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return newExpense;
}

	@PutMapping("expense/{id}")
	public Expense updateExpense(@PathVariable("id") Integer expenseId, @RequestBody Expense expense, HttpServletResponse resp) {
		Expense editExpense = null;
		
		try {
			editExpense = exp.update(expenseId, expense);
			
			if (expense == null) {
				
				resp.setStatus(404);
			} 
		}catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(400);
				editExpense = null;
			}
		return editExpense;
		
	}
	
	@PutMapping("expense/delete/{id}")
	public boolean disableExpense(@PathVariable("id") Integer expenseId, @RequestBody Expense expense, HttpServletResponse resp) {
		boolean deleted = false;
		try {
			deleted = exp.disableById(expenseId);
			if (expense == null) {
				resp.setStatus(404);
				
				return deleted;
			} 
		}catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(400);
			}
		return deleted;
		
		}
}
