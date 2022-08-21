package com.example.jpa;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Instructor;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.repository.InstructorRepository;

@SpringBootApplication
public class SpringbootJpaOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaOneToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingTest(InstructorRepository instructorRepository,CourseRepository courseRepository) {
		
		return Args ->{
			
			
			// Creating instructors & courses for testing
			Instructor i1= new Instructor();
			i1.setId(10);
			i1.setFirstName("nikhil");
			i1.setLastName("mowade");
			i1.setEmail("nm@gmail.com");
			instructorRepository.save(i1);
			
			courseRepository.save(new Course(2,"c1",120.0, i1));
			courseRepository.save(new Course(3,"c2",1200.0,i1));
			courseRepository.save(new Course(4,"c3",1300.0,i1));
			
			Instructor i2= new Instructor();
			i2.setId(10);
			i2.setFirstName("shubham");
			i2.setLastName("barsagade");
			i2.setEmail("sb@gmail.com");
			instructorRepository.save(i2);
			
			courseRepository.save(new Course(22,"s5",1100.0,i2));
			courseRepository.save(new Course(23,"s6",130.0,i2));
			courseRepository.save(new Course(24,"s7",123.0,i2));

		};	
		
	}

}
