package com.lovematch.match.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lovematch.match.jpa.entity.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long>, JpaSpecificationExecutor<Competition> {
	Page<Competition> findAllByType(String type, Pageable pageable);

}
