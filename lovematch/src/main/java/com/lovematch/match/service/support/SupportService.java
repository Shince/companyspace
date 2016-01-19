package com.lovematch.match.service.support;

import org.springframework.data.domain.Page;

import com.lovematch.match.jpa.entity.Support;
import com.lovematch.match.service.BaseService;



public interface SupportService extends BaseService<Support> {

	Page<Support> findAll(int pageNumber,int pageSize);
}
