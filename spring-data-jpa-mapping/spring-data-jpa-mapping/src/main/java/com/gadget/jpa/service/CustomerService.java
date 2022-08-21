package com.gadget.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gadget.jpa.entity.CustomerEntity;

@Component
public interface CustomerService {
	CustomerEntity saveCustomerEntity(CustomerEntity cust);

	List<CustomerEntity> getAllCustomerEntity();

	CustomerEntity getAnCustomerEntity(int id);

	CustomerEntity updateCustomerEntity(CustomerEntity cust, int id);

	String deleteCustomerEntity(int id);

	List<CustomerEntity> findByEmailLike(String email);
}
