package com.lovematch.match.service.webcont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lovematch.match.jpa.entity.WebCont;
import com.lovematch.match.jpa.repository.WebContRepository;
@Service("webContService")
public class WebContServiceImpl implements WebContService {
	@Autowired
	private WebContRepository contRepository;
	@Override
	public WebCont find(Long id) {
		return contRepository.findOne(id);
	}

	@Override
	public WebCont create(WebCont entity) {
		return contRepository.save(entity);
	}

	@Override
	public WebCont update(WebCont entity) {
		return contRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		contRepository.delete(id);
	}

	@Override
	public Page<WebCont> findWebContPageByType(String type,int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		return contRepository.findContByType(type, pageable);
	}

	@Override
	public Page<WebCont> findSubTitleByContType(String contType, int pageNumber,
			int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		return contRepository.findSubTitleFromWebCont(contType, pageable);
	}

	@Override
	public Page<WebCont> findWebContBySubTitleAndContType(String subTitle,
			String contType, int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		return contRepository.findWebContBySubTitleAndType(subTitle, contType, pageable);
	}

	@Override
	public Page<WebCont> findWebContPage(int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		return contRepository.findAll(pageable);
	}

}
