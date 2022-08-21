package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
	
	@Query("SELECT f from Instructor f where f.firstName=?1")
	public List<Instructor> getInstructorByFirstName(String firstName);
	
	
	@Query("SELECT l from Instructor l where l.lastName=?1")
	public List<Instructor> getInstructorByLastName(String lastName);
	
	
	@Query("SELECT e from Instructor e where e.email=?1")
	public List<Instructor> getInstructorByEmail(String email);


	public Iterable<Instructor> findInstructorByEmail(String string);
	
	
}
