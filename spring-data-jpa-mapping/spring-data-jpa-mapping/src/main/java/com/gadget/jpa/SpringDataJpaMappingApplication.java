package com.gadget.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gadget.jpa.entity.CustomerEntity;
import com.gadget.jpa.entity.ProductEntity;
import com.gadget.jpa.repository.CustomerRepository;
import com.gadget.jpa.repository.ProductRepository;

@SpringBootApplication
public class SpringDataJpaMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(CustomerRepository customerRepository, ProductRepository productRepository) {
		return args -> {

			CustomerEntity c = new CustomerEntity();
			c.setId(990);
			c.setName("amit");
			c.setEmail("gmail");
			c.setGender("male");
			customerRepository.save(c);

			productRepository.save(new ProductEntity(22, "p1", 11, 1000, c));
			productRepository.save(new ProductEntity(33, "p2", 12, 2000, c));
			productRepository.save(new ProductEntity(44, "p3", 13, 3000, c));
			productRepository.save(new ProductEntity(55, "p4", 14, 4000, c));

			CustomerEntity c2 = new CustomerEntity();
			c2.setId(87);
			c2.setName("shubham");
			c2.setEmail("shu@gmail.com");
			c2.setGender("male");
			customerRepository.save(c2);

			productRepository.save(new ProductEntity(73, "q1", 111, 2000, c2));
			productRepository.save(new ProductEntity(85, "q2", 125, 5000, c2));
			productRepository.save(new ProductEntity(95, "q3", 136, 7000, c2));
			productRepository.save(new ProductEntity(120, "q4", 149, 5000, c2));

			CustomerEntity c3 = new CustomerEntity();
			c3.setId(111);
			c3.setName("sanket");
			c3.setEmail("shu@yahoo.com");
			c3.setGender("male");
			customerRepository.save(c3);

			productRepository.save(new ProductEntity(731, "qqq1", 411, 2300, c3));
			productRepository.save(new ProductEntity(283, "qw2", 1285, 5500, c3));
			productRepository.save(new ProductEntity(793, "qt3", 1636, 7600, c3));
			productRepository.save(new ProductEntity(414, "qy4", 4149, 5700, c3));

			System.out.println("---- saved ------");

//			CustomerEntity ce = customerRepository.findById(1).get();
//			List<ProductEntity> pp = ce.getProductList();
//			for (ProductEntity p : pp)
//				System.out.println(p.getProductName() + " " + p.getPrice());
//
//			System.out.println("-----Query annotation test-----");
//			List<CustomerEntity> lc = customerRepository.findByEmailLike("gmail");
//			for (CustomerEntity t : lc)
//				System.out.println(t.getEmail() + " " + t.getName());
//			Iterable<CustomerEntity> lc1 = customerRepository.findCustomerByEmail("gmail");
//			for (CustomerEntity t : lc1)
//				System.out.println(t.getEmail() + " " + t.getName());
//
//			CustomerEntity lc2 = customerRepository.findByNameLike("shu");
//			System.out.println(lc2.getName() + " " + lc2.getEmail());
		};

	}

}
