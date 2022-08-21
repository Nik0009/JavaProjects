package edu.springwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.springwork.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
