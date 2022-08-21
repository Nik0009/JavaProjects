package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.entity.Course;

@Component
public interface CourseService {

	Course saveCourse(Course course);
	
	List<Course> getAllCourses();
	
	Course getAnCourse(int id);
	
	Course updateCourse(Course course,int id);
	
	String deleteCourse(int id);

	Course assignInstructorToCourse(Integer instructorId, Integer courseId);

	List<Course> findPaginated(int pageNo, int pageSize);

	List<Course> getByTitle(String title);
	
}
