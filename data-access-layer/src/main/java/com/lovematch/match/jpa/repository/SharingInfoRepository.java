package com.lovematch.match.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lovematch.match.jpa.entity.SharingInfo;

public interface SharingInfoRepository extends JpaRepository<SharingInfo, Long>, JpaSpecificationExecutor<SharingInfo> {
	
}
