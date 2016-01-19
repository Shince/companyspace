package com.lovematch.match.service.competition;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.service.BaseService;

public interface CompetitionService extends BaseService<Competition> {
	Page<Competition> findPageOrderById(int pageNumber,int pageSize, String order);
	List<Competition> findList(String order);
}
