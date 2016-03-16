package com.lovematch.match.jpa.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lovematch.match.jpa.entity.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long>, JpaSpecificationExecutor<Competition> {
	Page<Competition> findAllByType(String type, Pageable pageable);

	@Query("select c from Competition c where c.startDate <= :todayDate and c.endDate >= :todayDate")
	Page<Competition> findAllByCurrentDate(@Param( "todayDate" )Date currentDate, Pageable pageable);
	@Query("select c from Competition c where c.competitionStartDate <= :lastDate and c.endDate >= :firstDate")
	Page<Competition> findAllByFirstDateAndLastDate(@Param( "lastDate" )Date lastDate,@Param( "firstDate" )Date firstDate, Pageable pageable);
	Page<Competition> findAllByTitleLike(String title, Pageable pageable);

}

