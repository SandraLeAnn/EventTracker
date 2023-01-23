package com.skilldistillery.trips.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.trips.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
