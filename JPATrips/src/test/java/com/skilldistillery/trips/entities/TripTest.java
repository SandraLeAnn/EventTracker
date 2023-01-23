package com.skilldistillery.trips.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TripTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Trip trip;
	
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
		trip = em.find(Trip.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		trip = null;
		
	}

	@Test
	void test_trips_entity_mapping() {
//		mysql> select * from trip where id = 1;
//		+----+--------------------------+--------------------------------------------------------+--------------+-------------+------------+----------+-----------+---------+
//		| id | name                     | description                                            | location     | total_price | start_date | end_date | image_url | user_id |
//		+----+--------------------------+--------------------------------------------------------+--------------+-------------+------------+----------+-----------+---------+
//		|  1 | New Zealand Fishing Trip | I had an amazing time and caught so many rainbow trout | Auckland, NZ |       15000 | NULL       | NULL     | NULL      |       1 |
//		+----+--------------------------+--------------------------------------------------------+--------------+-------------+------------+----------+-----------+---------+		
		
		
		assertNotNull(trip);
		assertEquals("New Zealand Fishing Trip", trip.getName());
	}
	@Test
	void test_trip_relationship_to_user_entity_mapping() {
//		mysql> select * from user;
//		+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
//		| id | first_name | last_name | username | password | image_url | role  | active | email                 |
//		+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
//		|  1 | Sandra     | Harpole   | admin    | admin    | NULL      | admin |      1 | slharpole14@gmail.com |
//		+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+

		assertNotNull(trip);
		assertEquals("Sandra", trip.getUser().getFirstName());
	}
	@Test
	void test_trip_relationship_to_enpense_entity_mapping() {
		assertNotNull(trip);
		assertTrue(trip.getExpenses().size() > 0);
}
	
}
