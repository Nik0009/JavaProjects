package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

// public Iterable<Instructor> findInstructorByEmail(String email);
// 
// @Query("SELECT c FROM Instructor c WHERE c.email LIKE %?1%")
// List<Instructor> findByEmailLike(String email);
// 
// @Query("select c1 from Instructor c1 where c1.name LIKE %?1%")
// public Instructor findByNameLike(String name);

}
