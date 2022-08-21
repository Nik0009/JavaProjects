package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.entity.UserEntity;


@Component
public interface UserService {

	UserEntity savEntity(UserEntity params);
	
	List<UserEntity> getAllEntity();
	
	UserEntity getAnEntity(int id);
	
	UserEntity updateEntity(UserEntity params,int id);
	
	String deleteEntity(int id);
}
