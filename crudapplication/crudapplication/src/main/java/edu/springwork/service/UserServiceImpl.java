package edu.springwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springwork.entity.UserEntity;
import edu.springwork.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

//	UserServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}

	@Override
	public UserEntity saveEntity(UserEntity params) {
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
		UserEntity u = userRepository.findById(id).get();
		u.setEname(params.getEname());
		u.setEmail(params.getEmail());

		return userRepository.save(u);
	}

	@Override
	public String deleteEntity(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "User with id " + id + " has been deleted!!!!";
	}

}
