package com.example.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByTutorialId(Long postId);

	 @Transactional
	  void deleteByTutorialId(long tutorialId);
}
