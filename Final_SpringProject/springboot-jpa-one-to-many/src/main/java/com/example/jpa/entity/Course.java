package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity //(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@NotBlank(message = "Title must not be blank !!")
	private String title;
	
	@NotNull(message = "Price must not be null!!")
	Double price;
	

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_id",referencedColumnName = "id")
	private Instructor instructor;
	
	
	
	
}
