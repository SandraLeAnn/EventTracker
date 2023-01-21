package com.skilldistillery.trips.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.trips.entities.trips;

public interface TripsRepository extends JpaRepository<trips, Integer> {

}
