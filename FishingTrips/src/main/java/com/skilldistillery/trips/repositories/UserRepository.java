package com.skilldistillery.trips.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.trips.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
