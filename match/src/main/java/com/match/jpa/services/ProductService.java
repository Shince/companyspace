package com.match.jpa.services;

import java.util.List;

import com.match.entities.Product;

public interface ProductService {
	Product findOne(Long id);
	List<Product> findAll();
	Product create(Product product);
	Product update(Product product);
}
