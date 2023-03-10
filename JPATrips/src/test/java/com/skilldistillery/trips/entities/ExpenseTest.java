package com.skilldistillery.trips.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Expense exp;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf =Persistence.createEntityManagerFactory("JPATrips");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		exp = em.find(Expense.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		exp = null;
		
	}

	@Test
	void test_Expense_entity_mapping() {
//+----+-----------------------------+-------------+------+-----------+-------+----------+---------+
//| id | name                        | description | date | image_url | price | location | trip_id |
//+----+-----------------------------+-------------+------+-----------+-------+----------+---------+
//|  1 | Guided Rafting Fishing Trip | so much fun | NULL | NULL      |  1500 | NULL     |       1 |
//+----+-----------------------------+-------------+------+-----------+-------+----------+---------+
		
		assertNotNull(exp);
		assertEquals("Guided Rafting Fishing Trip", exp.getName());
		
}
	@Test
	void test_expense_relationship_to_trip_entity_mapping() {
//		+----+--------------------------+--------------------------------------------------------+--------------+-------------+------------+----------+-----------+---------+--------+
//		| id | name                     | description                                            | location     | total_price | start_date | end_date | image_url | user_id | active |
//		+----+--------------------------+--------------------------------------------------------+--------------+-------------+------------+----------+-----------+---------+--------+
//		|  1 | New Zealand Fishing Trip | I had an amazing time and caught so many rainbow trout | Auckland, NZ |       15000 | NULL       | NULL     | NULL      |       1 |      1 |
//		+----+--------------------------+--------------------------------------------------------+--------------+-------------+------------+----------+-----------+---------+--------+
		assertNotNull(exp);
		assertEquals("New Zealand Fishing Trip", exp.getTrip().getName());
	}
}