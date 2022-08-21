package com.example.jpa;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Instructor;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.repository.InstructorRepository;

@DataJpaTest
class TestTheMappingProject {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	InstructorRepository instructorRepository;
	
	
	@Autowired
	CourseRepository courseRepository;
	
	// testing storing an instructor
	@Test
	void should_store_an_instructor() {
		
		Instructor instructor=instructorRepository.save(new Instructor("nikhil","mowade","nm@gmail.com"));
		assertThat(instructor).hasFieldOrPropertyWithValue("firstName", "nikhil");
		assertThat(instructor).hasFieldOrPropertyWithValue("lastName", "mowade");
		assertThat(instructor).hasFieldOrPropertyWithValue("email", "nm@gmail.com");
		
	}
	
	// testing updating an instructor
	@Test
	void should_update_instructor() {
		
		Instructor instructor=instructorRepository.save(new Instructor("nikhil","mowade","nm@gmail.com"));
		
		testEntityManager.persist(instructor);
		
		Instructor updateInstructor = new Instructor("shubham","barsagade","sb@gmail.com");
		Instructor i=instructorRepository.findById(instructor.getId()).get();
		i.setFirstName(updateInstructor.getFirstName());
		i.setLastName(updateInstructor.getLastName());
		i.setEmail(updateInstructor.getEmail());
		instructorRepository.save(i);
		
		Instructor updateInstructor2 = instructorRepository.findById(instructor.getId()).get();
		assertThat(updateInstructor2.getFirstName()).isEqualTo(updateInstructor.getFirstName());
		assertThat(updateInstructor2.getLastName()).isEqualTo(updateInstructor.getLastName());
		assertThat(updateInstructor2.getEmail()).isEqualTo(updateInstructor.getEmail());
	}
	
	
	// testing deleting an instructor
	@Test
	void should_delete_an_instructor() {
		
		Instructor instructor=new Instructor("shubham","barsagade","sb@gmail.com");
		testEntityManager.persist(instructor);
		instructorRepository.deleteById(instructor.getId());
		assertThat(instructorRepository.findAll().isEmpty());
		
	}
	
	
	// testing storing an course
	@Test
	void should_store_course() {
		
		Instructor instructor=new Instructor("shubham","barsagade","sb@gmail.com");
		
		Course course= courseRepository.save(new Course(16,"s5",1100.0, instructor));
		assertThat(course).hasFieldOrPropertyWithValue("id",16 );
		assertThat(course).hasFieldOrPropertyWithValue("title", "s5");
		assertThat(course).hasFieldOrPropertyWithValue("price", 1100.0);
		
		
	}
	
	
	// testing getting an instructor by email
	@Test
	void should_find_instructor_by_email() {
		
		Instructor instructor=new Instructor("nikhil","mowade","nm@gmail.com");
		testEntityManager.persist(instructor);
		
		Iterable<Instructor> i = instructorRepository.findInstructorByEmail("nm@gmail.com");
//		assertThat(i).hasSize(1).contains(instructor);
		assertThat(instructor).hasFieldOrPropertyWithValue("email", "nm@gmail.com");
	}
	
	
	
}
