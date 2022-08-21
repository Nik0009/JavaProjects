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

import com.example.jpa.entity.Course;
import com.example.jpa.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
//	public CourseController(CourseService courseService) {
//	super();
//	this.courseService = courseService;
//}


	// save courses
	@PostMapping(value = "/savecourse")
	public Course saveCourse(@Valid @RequestBody Course course) {
		
		return courseService.saveCourse(course);
	}
	
	
	// get all courses
	@GetMapping(value = "/getallcourse")
	public List<Course> getAllCourses(){
		
		return courseService.getAllCourses();
	}
	
	// get courses by id
	@GetMapping(value = "/course/{id}")
	public Course getAnCourse(@PathVariable int id) {
		
		return courseService.getAnCourse(id);
	} 
	
	
	// update courses by id
	@PutMapping(value = "/course/{id}")
	public Course updateCourse(@Valid @PathVariable int id,@RequestBody Course course) {
		
		return courseService.updateCourse(course, id);
	}
	
	// delete courses by id
	@DeleteMapping("/course/{id}")
	public String deleteAnCourse(@PathVariable int id) {
		
		return courseService.deleteCourse(id);
	}
	
	// add instructor to courses by id of both
	@PutMapping("/course/{courseId}/instructors/{instructorId}")
	Course assignInstructorToCourse(@PathVariable Integer instructorId, @PathVariable Integer courseId)
	{
		return courseService.assignInstructorToCourse(instructorId,courseId);
	}	
	
	// pagination on courses
	@GetMapping("/course/{pageNo}/{pageSize}")
	public List<Course> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return courseService.findPaginated(pageNo,pageSize);
	}
	
	// query method for getting title
		@GetMapping("/course/title/{title}")
		public ResponseEntity<List<Course>> getCourseByTitle(@PathVariable String title){
			return new ResponseEntity<>(courseService.getByTitle(title),HttpStatus.OK);
		}
	
}
