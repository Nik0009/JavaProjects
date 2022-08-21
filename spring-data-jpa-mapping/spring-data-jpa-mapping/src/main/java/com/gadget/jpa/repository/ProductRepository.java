package com.gadget.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gadget.jpa.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
