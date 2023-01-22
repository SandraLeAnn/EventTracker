package com.skilldistillery.trips.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Column(name = "trip_id")
	private int tripId;

	public Expense() {
		super();
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

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", image="
				+ image + ", price=" + price + ", location=" + location + ", tripId=" + tripId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, description, id, image, location, name, price, tripId);
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
		return Objects.equals(date, other.date) && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(image, other.image) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && price == other.price && tripId == other.tripId;
	}

	
//mysql> select * from expense;
//+----+-----------------------------+-------------+------+-----------+-------+----------+---------+
//| id | name                        | description | date | image_url | price | location | trip_id |
//+----+-----------------------------+-------------+------+-----------+-------+----------+---------+
//|  1 | Guided Rafting Fishing Trip | so much fun | NULL | NULL      |  1500 | NULL     |       1 |
//+----+-----------------------------+-------------+------+-----------+-------+----------+---------+
}
