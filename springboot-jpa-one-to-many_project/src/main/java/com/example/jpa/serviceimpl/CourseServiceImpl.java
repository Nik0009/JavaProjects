package com.example.jpa.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Instructor;
import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.repository.InstructorRepository;
import com.example.jpa.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	InstructorRepository instructorRepository;
	
	
	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course getAnCourse(int id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course with id " + id + " Not Found!!!!!"));
	}

	@Override
	public Course updateCourse(Course course, int id) {
		// TODO Auto-generated method stub
		Course c= courseRepository.findById(id).get();
		c.setName(course.getName());
		c.setSubject(course.getSubject());
		
		return courseRepository.save(c);
	}

	@Override
	public String deleteCourse(int id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
		return "Course with id " + id + " has been deleted!!!!";
	}

	@Override
	public Course assignInstructorToCourse(Integer instructorId, Integer courseId) {
		
		Course course = courseRepository.findById(courseId).get();
		Instructor instructor = instructorRepository.findById(instructorId).get();
		course.setInstructor(instructor);
		
		return courseRepository.save(course);
	}


	
	
}
