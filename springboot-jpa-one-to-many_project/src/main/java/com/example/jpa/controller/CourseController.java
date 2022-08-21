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

import com.example.jpa.entity.Course;
import com.example.jpa.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@PostMapping(value = "/savecourse")
	public Course saveCourse(@RequestBody Course course) {
		
		return courseService.saveCourse(course);
	}
	
	@GetMapping(value = "/getallcourse")
	public List<Course> getAnCourses(){
		return courseService.getAllCourses();
	}
	
	
	@GetMapping(value = "/course/{id}")
	public Course getAnCourse(@PathVariable int id) {
		return courseService.getAnCourse(id);
	}
	
	@PutMapping(value = "/course/{id}")
	public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
		return courseService.updateCourse(course, id);
	}
	
	
	@DeleteMapping(value = "/course/{id}")
	public String deleteAnCourse(@PathVariable int id) {
		return courseService.deleteCourse(id);
	}
	
	
	@PutMapping("/{courseId}/instructors/{instructorId}")
	Course assignInstructorToCourse(@PathVariable Integer instructorId, @PathVariable Integer courseId)
	{
		return courseService.assignInstructorToCourse(instructorId,courseId);
	}	
	
	
	
	
}
