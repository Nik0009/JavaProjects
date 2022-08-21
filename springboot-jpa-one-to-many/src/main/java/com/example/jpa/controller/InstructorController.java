package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Instructor;
import com.example.jpa.service.InstructorService;

@RestController
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	
	@PostMapping(value = "/saveinstructor")
	public Instructor saveInstructor(@RequestBody Instructor instructor) {
		
		return instructorService.saveInstructor(instructor);
		
	}
	
	@GetMapping(value = "/getallinstructor")
	public List<Instructor> getAllInstructor(){
		return instructorService.getAllInstructors();
	}
	
	@GetMapping(value = "/instructor/{id}")
	public Instructor getAnInstructor(@PathVariable int id) {
		
		return instructorService.getAnInstructor(id);
	}
	
	@PutMapping(value = "/instructor/{id}")
	public Instructor updateInstructor(@PathVariable int id,@RequestBody Instructor instructor) {
		
		return instructorService.updateInstructor(instructor, id);
		
	}
	
	@DeleteMapping(value = "/instructor/{id}")
	public String deleteAnInstructor(@PathVariable int id) {
		
		return instructorService.deleteInstructor(id);
	}
	
//	@GetMapping(value = "/instructor/{email}")
//	public List<Instructor> getInstructors(@PathVariable String email){
//		return instructorService.findByEmailLike(email);
//	}
	
}
