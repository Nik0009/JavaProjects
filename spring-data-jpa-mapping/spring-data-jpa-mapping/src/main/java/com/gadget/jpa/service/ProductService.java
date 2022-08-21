package com.gadget.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gadget.jpa.entity.ProductEntity;

@Component
public interface ProductService {
	ProductEntity saveProductEntity(ProductEntity pro);

	List<ProductEntity> getAllProductEntity();

	ProductEntity getAnProductEntity(int id);

	ProductEntity updateProductEntity(ProductEntity pro, int id);

	String deleteProductEntity(int id);
}
