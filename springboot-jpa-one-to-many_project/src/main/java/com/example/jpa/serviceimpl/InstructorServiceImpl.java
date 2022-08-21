package com.example.jpa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Instructor;
import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.repository.InstructorRepository;
import com.example.jpa.service.InstructorService;
@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorRepository instructorRepository;
	
	
	@Override
	public Instructor saveInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorRepository.save(instructor);
	}

	@Override
	public List<Instructor> getAllInstructors() {
		// TODO Auto-generated method stub
		return instructorRepository.findAll();
	}

	@Override
	public Instructor getAnInstructor(int id) {
		// TODO Auto-generated method stub
		return instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor with id " + id + " Not Found!!!!!"));
	}

	@Override
	public Instructor updateInstructor(Instructor instructor, int id) {
		// TODO Auto-generated method stub
		Instructor i= instructorRepository.findById(id).get();
		i.setName(instructor.getName());
		i.setEmail(instructor.getEmail());
		return instructorRepository.save(i);
	}

	@Override
	public String deleteInstructor(int id) {
		// TODO Auto-generated method stub
		instructorRepository.deleteById(id);
		return "Instructor with id " + id + " has been deleted!!!!";
	}

}
