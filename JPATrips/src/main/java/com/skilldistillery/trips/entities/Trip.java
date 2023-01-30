package com.skilldistillery.trips.entities;


import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
	public class Trip {
		
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		
		private String Description;
		
		private String location;
		
		@Column(name = "total_price")
		private int totalPrice;
		
		@Column(name = "start_date")
		private String startDate;
		
		@Column(name = "end_date")
		private String endDate;
		
		@Column(name ="image_url")
		private String image;
		
		private boolean active;
		
		
		@JsonIgnore
		@OneToMany(mappedBy = "trip")
		private List<Expense> expenses;
		
		
		public Trip() {
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
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public int getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}

	

		public String getStartDate() {
			return startDate;
		}



		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}



		public String getEndDate() {
			return endDate;
		}



		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}



		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
		

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		
		public List<Expense> getExpenses() {
			return expenses;
		}


		public void setExpenses(List<Expense> expenses) {
			this.expenses = expenses;
		}



		@Override
		public String toString() {
			return "Trip [id=" + id + ", name=" + name + ", Description=" + Description + ", location=" + location
					+ ", totalPrice=" + totalPrice + ", startDate=" + startDate + ", endDate=" + endDate + ", image="
					+ image + ", active=" + active + ", expenses=" + expenses + "]";
		}



		@Override
		public int hashCode() {
			return Objects.hash(Description, active, endDate, expenses, id, image, location, name, startDate,
					totalPrice);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Trip other = (Trip) obj;
			return Objects.equals(Description, other.Description) && active == other.active
					&& Objects.equals(endDate, other.endDate) && Objects.equals(expenses, other.expenses)
					&& id == other.id && Objects.equals(image, other.image) && Objects.equals(location, other.location)
					&& Objects.equals(name, other.name) && Objects.equals(startDate, other.startDate)
					&& totalPrice == other.totalPrice;
		}



	
}
