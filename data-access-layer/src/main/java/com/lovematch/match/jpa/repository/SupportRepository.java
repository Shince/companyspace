package com.lovematch.match.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lovematch.match.jpa.entity.Support;



public interface SupportRepository extends JpaRepository<Support, Long>,JpaSpecificationExecutor<Support> {
	
}
