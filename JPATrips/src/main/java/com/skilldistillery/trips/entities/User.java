package com.skilldistillery.trips.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	private String username;
	
	private String password;
	
	@Column(name = "image_url")
	private String image;
	
	private String role;
	
	private boolean active;
	
	private String email;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", image=" + image + ", role=" + role + ", active=" + active + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, email, firstName, id, image, lastName, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return active == other.active && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(username, other.username);
	}
	
//	mysql> select * from user where id = 1;
//	+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
//	| id | first_name | last_name | username | password | image_url | role  | active | email                 |
//	+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
//	|  1 | Sandra     | Harpole   | admin    | admin    | NULL      | admin |      1 | slharpole14@gmail.com |
//	+----+------------+-----------+----------+----------+-----------+-------+--------+-----------------------+
//

	

}
