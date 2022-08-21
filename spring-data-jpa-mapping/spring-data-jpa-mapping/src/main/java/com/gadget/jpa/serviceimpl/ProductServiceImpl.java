package com.gadget.jpa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gadget.jpa.entity.ProductEntity;
import com.gadget.jpa.exception.ResourceNotFoundException;
import com.gadget.jpa.repository.ProductRepository;
import com.gadget.jpa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductEntity saveProductEntity(ProductEntity product) {
		return productRepository.save(product);
	}

	@Override
	public List<ProductEntity> getAllProductEntity() {
		return productRepository.findAll();
	}

	@Override
	public ProductEntity getAnProductEntity(int id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " Not Found!!!!!"));
	}

	@Override
	public ProductEntity updateProductEntity(ProductEntity product, int id) {
		ProductEntity p=productRepository.findById(id).get();
		p.setProductName(product.getProductName());
		p.setQty(product.getQty());
		p.setPrice(product.getPrice());
		return productRepository.save(p);
	}

	@Override
	public String deleteProductEntity(int id) {
		productRepository.deleteById(id);
		return "Product with id " + id + " has been deleted!!!!";

	}

}
