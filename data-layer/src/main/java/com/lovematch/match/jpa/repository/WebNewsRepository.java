package com.lovematch.match.jpa.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lovematch.match.jpa.entity.WebNews;



public interface WebNewsRepository extends JpaRepository<WebNews, Long>, JpaSpecificationExecutor<WebNews> {
	Page<WebNews> findAllByType(String type, Pageable pageable);
}
