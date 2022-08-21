package com.gadget.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gadget.jpa.entity.CustomerEntity;
import com.gadget.jpa.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

//	@PostMapping(value = "/savecustomer")
//	public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomerEntity cust) {
//		customerService.saveCustomerEntity(cust);
//		return ResponseEntity.ok("User is valid");
//
//	}
	@PostMapping(value = "/savecustomer")
	public CustomerEntity saveCustomer(@RequestBody CustomerEntity cust) {
		return customerService.saveCustomerEntity(cust);

	}

	@GetMapping(value = "/getallcustomer")
	public List<CustomerEntity> getAnCustomerEntity() {
		return customerService.getAllCustomerEntity();

	}

	@GetMapping(value = "/customer/{id}")
	public CustomerEntity getAnCustomerEntity(@PathVariable int id) {
		return customerService.getAnCustomerEntity(id);

	}

	@PutMapping(value = "/customer/{id}")
	public CustomerEntity updateAnCustomerEntity(@PathVariable int id, @RequestBody CustomerEntity cust) {

		return customerService.updateCustomerEntity(cust, id);

	}

	@DeleteMapping(value = "/user/{id}")
	public String deleteAnCustomerEntity(@PathVariable int id) {

		return customerService.deleteCustomerEntity(id);

	}

	// query method
	@GetMapping(value = "/cusromer/{email}")
	public List<CustomerEntity> getCustomerEntity(@PathVariable String email) {
		return customerService.findByEmailLike(email);
	}
}
