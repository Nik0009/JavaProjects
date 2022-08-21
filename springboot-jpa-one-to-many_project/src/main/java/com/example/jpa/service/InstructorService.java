package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.entity.Instructor;

@Component
public interface InstructorService {

	Instructor saveInstructor(Instructor instructor);
	
	List<Instructor> getAllInstructors();
	
	Instructor getAnInstructor(int id);
	
	Instructor updateInstructor(Instructor instructor,int id);
	
	String deleteInstructor(int id);

	
	
}
