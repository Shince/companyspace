package com.lovematch.match.service.competition;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.service.BaseService;

public interface CompetitionService extends BaseService<Competition> {
	Page<Competition> findPageOrderById(int pageNumber,int pageSize, String order);
	Page<Competition> findPageByType(String type, int pageNumber,int pageSize);
	Page<Competition> findPageByTypeDesc(String type, int pageNumber,int pageSize);
	List<Competition> findList(String order);
	Page<Competition> findPageByCurrentDate(int pageNumber,int pageSize, Date currentDate);

	Page<Competition> findPageByOrderAndFirstDateAndLastDate(int pageNumber,int pageSize,String order, Date firstDate, Date lastDate);
	Page<Competition> findPageByTitleLikeDesc(String title, int pageNumber,int pageSize);
	Page<Competition> findPageByTitleLike(String title, int pageNumber,int pageSize);
	
	Page<Competition> findPageActiveByType(String type, int pageNumber, int pageSize, Date currentDate);
	Page<Competition> findPageActiveByTypeDesc(String type, int pageNumber, int pageSize, Date currentDate);
}
