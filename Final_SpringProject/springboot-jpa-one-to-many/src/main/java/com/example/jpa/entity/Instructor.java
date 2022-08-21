package com.example.jpa.entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@NotNull(message = "First Name Cannot Be Null !!")
	@Size(min = 4, message = "First Name must not be less than 4 characters !")
 	private String firstName;
	
	
	@NotNull(message = "Last Name Cannot Be Null !!")
	@Size(min = 4, message = "Last Name must not be less than 4 characters !")
 	private String lastName;
	
	@NotBlank(message = "Email must not be blank !!")
	@Email(message = "Email is not valid !!")
 	
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "instructor")
	private List<Course> courses;

	public Instructor( String firstName, String lastName, String email) {
		super();// super calls the immediate parent class zero args counstructor 
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	

}
