package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query("SELECT c from Course c where c.title=?1")
	public List<Course> getCourseByTitle(String title);
}
