package com.lovematch.match.service.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lovematch.match.jpa.entity.WebNews;
import com.lovematch.match.jpa.repository.WebNewsRepository;

@Service("webNewsService")
public class WebNewsServiceImpl implements WebNewsService {
	
	@Autowired
	private WebNewsRepository webNewsRepository;
	
	@Override
	public WebNews find(Long id) {
		return webNewsRepository.findOne(id);
	}

	@Override
	public WebNews create(WebNews entity) {
		return webNewsRepository.save(entity);
	}

	@Override
	public WebNews update(WebNews entity) {
		return webNewsRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		webNewsRepository.delete(id);
	}

	@Override
	public Page<WebNews> findNewsPageByType(int pageNumber, int pageSize,String type) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		return webNewsRepository.findAllByType(type, pageable);
	}

	@Override
	public Page<WebNews> findNewsPage(int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		return webNewsRepository.findAll(pageable);
	}

}
