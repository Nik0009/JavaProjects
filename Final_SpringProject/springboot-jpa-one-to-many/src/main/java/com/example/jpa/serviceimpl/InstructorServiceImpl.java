package com.example.jpa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Instructor;
import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.repository.InstructorRepository;
import com.example.jpa.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService{
	
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
				.orElseThrow(() -> new ResourceNotFoundException("Instructor with id"+ id +" Not Found !!!!!!!!"));
	}

	@Override
	public Instructor updateInstructor(Instructor instructor, int id) {
		// TODO Auto-generated method stub
		Instructor i= instructorRepository.findById(id).get();
		i.setFirstName(instructor.getFirstName());
		i.setLastName(instructor.getLastName());
		i.setEmail(instructor.getEmail());
		
		return instructorRepository.save(i);
	}

	@Override
	public String deleteInstructor(int id) {
		// TODO Auto-generated method stub
		instructorRepository.deleteById(id);
		return "Instructor with id "+ id +" has been deleted !!!!!!!";
	}

	@Override
	public List<Instructor> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Instructor> pageRessult = instructorRepository.findAll(paging);
		return pageRessult.toList();
	}	
	
	@Override
	public List<Instructor> getByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return instructorRepository.getInstructorByFirstName(firstname);
		
	}
	
	
	
	@Override
	public List<Instructor> getByEmail(String email) {
		// TODO Auto-generated method stub
		return instructorRepository.getInstructorByEmail(email);
	}

	@Override
	public List<Instructor> getByLastname(String lastname) {
		// TODO Auto-generated method stub
		return instructorRepository.getInstructorByLastName(lastname);
	}
}
