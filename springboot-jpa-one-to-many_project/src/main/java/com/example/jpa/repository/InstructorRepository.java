package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	List<Course> findAllById(int instructorId);

}
