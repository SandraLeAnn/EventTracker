package com.skilldistillery.trips.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
		private LocalDateTime startDate;
		
		@Column(name = "end_date")
		private LocalDateTime endDate;
		
		@Column(name ="image_url")
		private String image;

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

		public LocalDateTime getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
		}

		public LocalDateTime getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDateTime endDate) {
			this.endDate = endDate;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		@Override
		public String toString() {
			return "Trip [id=" + id + ", name=" + name + ", Description=" + Description + ", location=" + location
					+ ", totalPrice=" + totalPrice + ", startDate=" + startDate + ", endDate=" + endDate + ", image="
					+ image + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(Description, endDate, id, image, location, name, startDate, totalPrice);
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
			return Objects.equals(Description, other.Description) && Objects.equals(endDate, other.endDate)
					&& id == other.id && Objects.equals(image, other.image) && Objects.equals(location, other.location)
					&& Objects.equals(name, other.name) && Objects.equals(startDate, other.startDate)
					&& totalPrice == other.totalPrice;
		}
		
//		
//		@Column(name ="user_id")
//		private String userID;
		

}
