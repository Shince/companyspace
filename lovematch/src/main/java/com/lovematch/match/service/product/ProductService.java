package com.lovematch.match.service.product;

import java.util.List;

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.Product;
import com.lovematch.match.service.BaseService;

public interface ProductService extends BaseService<Product> {
	List<Product> findAllByCompetition(Competition competition);
}
