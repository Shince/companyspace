package com.lovematch.match.service.news;

import org.springframework.data.domain.Page;

import com.lovematch.match.jpa.entity.WebNews;
import com.lovematch.match.service.BaseService;

public interface WebNewsService extends BaseService<WebNews> {
	Page<WebNews> findNewsPageByType(int pageNumber, int pageSize,String type);
	Page<WebNews> findNewsPage(int pageNumber, int pageSize);
}
