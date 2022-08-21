package com.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.entity.UserEntity;
import com.demo.repository.UserRepository;
@DataJpaTest
public class JPATest {

//	@Autowired
//	private TestEntityManager testEntityManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void should_find_no_user_if_repository_is_empty()
	{
	Iterable<UserEntity> userEntity=userRepository.findAll();
	assertThat(userEntity).isEmpty();
	
	}
	@Test
	public void should_store_an_user() 
	{
		
	UserEntity u=	userRepository.save(new UserEntity("a","a@gmail.com"));
		assertThat(u).hasFieldOrPropertyWithValue("name", "a");
		assertThat(u).hasFieldOrPropertyWithValue("email", "a@gmail.com"); 
	}

}
