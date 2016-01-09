package com.match.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.match.entities.SharingInfo;

@Transactional
public interface SharingInfoRepository extends JpaRepository<SharingInfo, Long>, JpaSpecificationExecutor<SharingInfo> {

}
