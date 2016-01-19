package com.lovematch.match.service.webcont;

import org.springframework.data.domain.Page;

import com.lovematch.match.jpa.entity.WebCont;
import com.lovematch.match.service.BaseService;

public interface WebContService extends BaseService<WebCont> {
	Page<WebCont> findWebContPageByType(String type, int pageNumber, int pageSize);
	Page<WebCont> findWebContPage( int pageNumber, int pageSize);
	Page<WebCont> findSubTitleByContType(String contType, int pageNumber, int pageSize);
	Page<WebCont> findWebContBySubTitleAndContType(String subTitle,String ContType, int pageNumber, int pageSize);
}
