package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Instructor;

@Component
public interface CourseService {

	Course saveCourse(Course course);
	
	List<Course> getAllCourses();
	
	Course getAnCourse(int id);
	
	Course updateCourse(Course course,int id);
	
	String deleteCourse(int id);

	Course assignInstructorToCourse(Integer instructorId, Integer courseId);


}
