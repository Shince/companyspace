package com.lovematch.match.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.Product;
import com.lovematch.match.jpa.repository.ProductRepository;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product find(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public Product create(Product entity) {
		
		return repository.save(entity);
	}

	@Override
	public Product update(Product entity) {
		
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);

	}

	@Override
	public List<Product> findAllByCompetition(Competition competition) {
		
		return repository.findAllByCompetition(competition);
	}

}
