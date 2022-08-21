package com.example.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	// save instructor
	@PostMapping(value = "/saveinstructor")
	public Instructor saveInstructor( @Valid @RequestBody Instructor instructor) {
		
		return instructorService.saveInstructor(instructor);
		
	}
	
//	@PostMapping(value = "/saveinstructor")
//	public ResponseEntity<Instructor> saveInstructor( @RequestBody @Valid Instructor instructor) {
//		
//		return new ResponseEntity<>(instructorService.saveInstructor(instructor),HttpStatus.OK);
//		
//	}
	
	// get all instructor
	@GetMapping(value = "/getallinstructor")
	public List<Instructor> getAllInstructor(){
		return instructorService.getAllInstructors();
	}
	
	// get instructor by id
	@GetMapping(value = "/instructor/{id}")
	public Instructor getAnInstructor(@PathVariable int id) {
		
		return instructorService.getAnInstructor(id);
	}
	
	// update instructor by id
	@PutMapping(value = "/instructor/{id}")
	public Instructor updateInstructor(@Valid @RequestBody Instructor instructor,@PathVariable int id) {
		
		return instructorService.updateInstructor(instructor, id);
		
	}
	
	
	// delete instructor by id
	@DeleteMapping(value = "/instructor/{id}")
	public String deleteAnInstructor(@PathVariable int id) {
		
		return instructorService.deleteInstructor(id);
	}
	
	
	// pagination on instructors
	@GetMapping("/instructor/{pageNo}/{pageSize}")
	public List<Instructor> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return instructorService.findPaginated(pageNo,pageSize);
	}	
	
	
	// query method for getting firstname
	@GetMapping("/instructor/firstname/{firstname}")
	public ResponseEntity<List<Instructor>> getInstructorByFirstname(@PathVariable String firstname){
		return new ResponseEntity<>(instructorService.getByFirstname(firstname),HttpStatus.OK);
	}
	
	
	// query method for getting lastname
	@GetMapping("/instructor/lastname/{lastname}")
	public ResponseEntity<List<Instructor>> getInstructorByLastname(@PathVariable String lastname){
		return new ResponseEntity<>(instructorService.getByLastname(lastname),HttpStatus.OK);
	}
		
	
	// query method for getting email
	@GetMapping("/instructor/email/{email}")
	public ResponseEntity<List<Instructor>> getInstructorByEmail(@PathVariable String email){
		return new ResponseEntity<>(instructorService.getByEmail(email),HttpStatus.OK);
	}

	
}
