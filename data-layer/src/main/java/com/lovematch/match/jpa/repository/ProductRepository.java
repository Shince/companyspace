package com.lovematch.match.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	Page<Product> findPageByCompetition(Competition competition,Pageable pageable);
	List<Product> findAllByCompetition(Competition competition);
}
