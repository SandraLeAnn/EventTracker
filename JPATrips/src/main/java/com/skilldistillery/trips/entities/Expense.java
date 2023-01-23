package com.skilldistillery.trips.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	private String date;
	
	@Column(name = "image_url")
	private String image;
	
	private int price;
	
	private String location;
	
	private boolean active;
	
	
	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;

	public Expense() {
		super();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}



	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", image="
				+ image + ", price=" + price + ", location=" + location + ", active=" + active + ", trip=" + trip + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(active, date, description, id, image, location, name, price, trip);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		return active == other.active && Objects.equals(date, other.date)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(image, other.image) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && price == other.price && Objects.equals(trip, other.trip);
	}



}
