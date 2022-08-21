package com.example.jpa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getAnCourse(int id) {
		return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course with id "+id+" Not Found !!!!!!!"));
	}

	@Override
	public Course updateCourse(Course course, int id) {
		Course c=courseRepository.findById(id).get();
		c.setTitle(course.getTitle());
		
		return courseRepository.save(c);
	}

	@Override
	public String deleteCourse(int id) {
		courseRepository.deleteById(id);;
		return "Course with id "+ id +" has been deleted !!!!!!";
	}

	@Override
	public Course assignInstructorToCourse(Integer instructorId, Integer courseId) {
		
		Course course = courseRepository.findById(courseId).get();
		Instructor instructor = instructorRepository.findById(instructorId).get();
		course.setInstructor(instructor);
		
		return courseRepository.save(course);
	}

	@Override
	public List<Course> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Course> pageRessult = courseRepository.findAll(paging);
		return pageRessult.toList();
	}

	@Override
	public List<Course> getByTitle(String title) {
		// TODO Auto-generated method stub
		return courseRepository.getCourseByTitle(title);
	}

}
