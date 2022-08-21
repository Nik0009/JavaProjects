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

import com.gadget.jpa.entity.ProductEntity;
import com.gadget.jpa.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/saveproduct")
	public ProductEntity savepProductEntity(@RequestBody ProductEntity pro) {
		return productService.saveProductEntity(pro);

	}

	@GetMapping(value = "/getallproduct")
	public List<ProductEntity> getAnProductEntity() {
		return productService.getAllProductEntity();

	}

	@GetMapping(value = "/product/{id}")
	public ProductEntity getAnProductEntity(@PathVariable int id) {
		return productService.getAnProductEntity(id);

	}

	@PutMapping(value = "/product/{id}")
	public ProductEntity updateAnProductEntity(@PathVariable int id, @RequestBody ProductEntity pro) {

		return productService.updateProductEntity(pro, id);

	}

	@DeleteMapping(value = "/product/{id}")
	public String deleteAnProductEntity(@PathVariable int id) {

		return productService.deleteProductEntity(id);

	}
}
