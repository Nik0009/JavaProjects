package com.gadget.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.gadget.jpa.entity.CustomerEntity;
import com.gadget.jpa.entity.ProductEntity;
import com.gadget.jpa.repository.CustomerRepository;
import com.gadget.jpa.repository.ProductRepository;

@DataJpaTest
class ProjectTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductRepository productRepository;

	@Test
	void should_store_an_customer() {
		CustomerEntity c = customerRepository.save(new CustomerEntity("shubham", "a@gmail.com", "Male"));
		assertThat(c).hasFieldOrPropertyWithValue("name", "shubham");
		assertThat(c).hasFieldOrPropertyWithValue("email", "a@gmail.com");
		assertThat(c).hasFieldOrPropertyWithValue("gender", "Male");

	}

	@Test
	void should_update_customer() {
		CustomerEntity c = new CustomerEntity("shubham", "a@gmail.com", "Male");
		testEntityManager.persist(c);
		CustomerEntity updated = new CustomerEntity("amitava", "abc@hotmail.com", "Male");
		CustomerEntity k = customerRepository.findById(c.getId()).get();
		k.setName(updated.getName());
		k.setEmail(updated.getEmail());
		k.setGender(updated.getGender());
		customerRepository.save(k);
		CustomerEntity kupdated = customerRepository.findById(c.getId()).get();
		assertThat(kupdated.getName()).isEqualTo(updated.getName());
		assertThat(kupdated.getEmail()).isEqualTo(updated.getEmail());
		assertThat(kupdated.getGender()).isEqualTo(updated.getGender());

	}

	@Test
	void should_delete_customer() {
		CustomerEntity c = new CustomerEntity("abc", "a@gmail.com", "Male");
		testEntityManager.persist(c);
		customerRepository.deleteById(c.getId());
		assertThat(customerRepository.findAll().isEmpty());
	}

	@Test
	public void should_delete_all_customer() {
		CustomerEntity c1 = new CustomerEntity("abc", "a@gmail", "female");
		testEntityManager.persist(c1);
		CustomerEntity c2 = new CustomerEntity("abc", "a@gmail.com", "Male");
		testEntityManager.persist(c2);
		customerRepository.deleteAll();
		assertThat(customerRepository.findAll()).isEmpty();
	}

	@Test
	void should_store_an_product() {
		CustomerEntity c = customerRepository.save(new CustomerEntity("shubham", "a@gmail.com", "Male"));
		/*
		 * assertThat(c).hasFieldOrPropertyWithValue("name", "shubham");
		 * assertThat(c).hasFieldOrPropertyWithValue("email", "a@gmail.com");
		 * assertThat(c).hasFieldOrPropertyWithValue("gender", "Male");
		 */

		ProductEntity p = productRepository.save(new ProductEntity(2, "p1", 11, 1000, c));
		assertThat(p).hasFieldOrPropertyWithValue("productId", 2);
		assertThat(p).hasFieldOrPropertyWithValue("productName", "p1");
		assertThat(p).hasFieldOrPropertyWithValue("qty", 11);
		assertThat(p).hasFieldOrPropertyWithValue("price", 1000);

	}

	// query method
	

	@Test
	void should_find_customer_by_email() {
		CustomerEntity c = new CustomerEntity("shubham", "a@gmail.com", "Male");
		testEntityManager.persist(c);

		Iterable<CustomerEntity> cs = customerRepository.findCustomerByEmail("a@gmail.com");
		assertThat(cs).hasSize(1).contains(c);
	}

}
