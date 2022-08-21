package com.gadget.jpa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gadget.jpa.entity.CustomerEntity;
import com.gadget.jpa.exception.ResourceNotFoundException;
import com.gadget.jpa.repository.CustomerRepository;
import com.gadget.jpa.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerEntity saveCustomerEntity(CustomerEntity cust) {
		return customerRepository.save(cust);
	}

	@Override
	public List<CustomerEntity> getAllCustomerEntity() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerEntity getAnCustomerEntity(int id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " Not Found!!!!!"));
	}

	@Override
	public CustomerEntity updateCustomerEntity(CustomerEntity cust, int id) {
		CustomerEntity c = customerRepository.findById(id).get();
		c.setName(cust.getName());
		c.setEmail(cust.getEmail());
		c.setGender(cust.getGender());
		return customerRepository.save(c);
	}

	@Override
	public String deleteCustomerEntity(int id) {
		customerRepository.deleteById(id);
		return "Customer with id " + id + " has been deleted!!!!";
	}

	@Override
	public List<CustomerEntity> findByEmailLike(String email) {
		return customerRepository.findByEmailLike(email);

	}

}
