package com.lovematch.match.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lovematch.match.jpa.entity.Support;
import com.lovematch.match.jpa.repository.SupportRepository;

@Service("supportService")
public class SupportServiceImpl implements SupportService {
	@Autowired
	private SupportRepository repository;
	@Override
	public Support create(Support support) {
		
		return repository.save(support);
	}

	@Override
	public Support update(Support support) {
		return repository.save(support);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);

	}

	@Override
	public Support find(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Support> findAll(int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize,
				Direction.DESC, "id");
		Page<Support> page = repository.findAll(pageable);
		return page;
	}

}
