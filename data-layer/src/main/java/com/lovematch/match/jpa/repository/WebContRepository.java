package com.lovematch.match.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lovematch.match.jpa.entity.WebCont;

public interface WebContRepository extends JpaRepository<WebCont, Long>, JpaSpecificationExecutor<WebCont> {
	Page<WebCont> findContByType(String type,Pageable pageable);
	
	@Query("select c from WebCont c where c.type = ?1 group by c.subTitle")
	Page<WebCont> findSubTitleFromWebCont(String contType,Pageable pageable);
	
	Page<WebCont> findWebContBySubTitleAndType(String subTitle,String type, Pageable pageable);
}
