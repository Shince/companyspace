package com.lovematch.match.service.sharinginfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lovematch.match.jpa.entity.SharingInfo;
import com.lovematch.match.jpa.repository.SharingInfoRepository;
@Service("sharingInfoService")
public class SharingInfoServiceImpl implements SharingInfoService {
	@Autowired
	private SharingInfoRepository repository;
	@Override
	public SharingInfo find(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public SharingInfo create(SharingInfo entity) {
		
		return repository.save(entity);
	}

	@Override
	public SharingInfo update(SharingInfo entity) {
		
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	

	@Override
	public List<SharingInfo> findList() {
		
		return repository.findAll();
	}

	@Override
	public Page<SharingInfo> findPageOrderByDate(int pageNumber, int pageSize,
			String order) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		
		return repository.findAll(pageable);
	}

}
