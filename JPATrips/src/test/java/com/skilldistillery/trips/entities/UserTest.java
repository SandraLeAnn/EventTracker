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

public class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
		
	}

	@Test
	void test_User_entity_mapping() {
//	mysql> select * from user where id = 1;
//	+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
//	| id | first_name | last_name | username | password | image_url | role  | active | email                 |
//	+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
//	|  1 | Sandra     | Harpole   | admin    | admin    | NULL      | admin |      1 | slharpole14@gmail.com |
//	+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
		assertNotNull(user);
		assertEquals("Sandra", user.getFirstName());
//
}
}