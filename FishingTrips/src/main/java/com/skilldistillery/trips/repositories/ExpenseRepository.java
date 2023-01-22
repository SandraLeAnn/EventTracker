package com.skilldistillery.trips.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.trips.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
