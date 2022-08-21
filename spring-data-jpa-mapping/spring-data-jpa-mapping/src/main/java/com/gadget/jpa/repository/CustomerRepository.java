package com.gadget.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gadget.jpa.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

	public Iterable<CustomerEntity> findCustomerByEmail(String string);

	@Query("SELECT c FROM CustomerEntity c WHERE c.email LIKE %?1%")
	List<CustomerEntity> findByEmailLike(String email);

	@Query("select c1 from CustomerEntity c1 where c1.name LIKE %?1%")
	public CustomerEntity findByNameLike(String name);
}
