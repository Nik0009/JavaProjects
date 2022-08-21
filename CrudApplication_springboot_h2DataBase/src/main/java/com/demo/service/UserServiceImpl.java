package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.UserEntity;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity savEntity(UserEntity params) {
		// TODO Auto-generated method stub
		return userRepository.save(params);
	}

	@Override
	public List<UserEntity> getAllEntity() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserEntity getAnEntity(int id) {
		// TODO Auto-generated method stub
		
		return userRepository.findById(id).get();
	}

	@Override
	public UserEntity updateEntity(UserEntity params, int id) {
		// TODO Auto-generated method stub
		UserEntity u=userRepository.findById(id).get();
		u.setName(params.getName());
		u.setEmail(params.getEmail());
		return userRepository.save(u);
	}

	@Override
	public String deleteEntity(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "User with id"+id+"has been deleted!!!!";
	}

}
