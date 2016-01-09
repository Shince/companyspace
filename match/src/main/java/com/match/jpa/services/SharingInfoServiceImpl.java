package com.match.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.match.entities.SharingInfo;
import com.match.jpa.repository.SharingInfoRepository;

@Transactional
@Service("sharingInfoService")
public class SharingInfoServiceImpl implements SharingInfoService {

	@Autowired
	private SharingInfoRepository sharingInfoRepository;
	
	
	@Override
	public SharingInfo findOne(Long id) {
		return sharingInfoRepository.findOne(id);
	}

	@Override
	public List<SharingInfo> findAll() {
		return sharingInfoRepository.findAll();
	}

	@Override
	public SharingInfo create(SharingInfo sharingInfo) {
		return sharingInfoRepository.save(sharingInfo);
	}

	@Override
	public SharingInfo update(SharingInfo sharingInfo) {
		return sharingInfoRepository.save(sharingInfo);
	}

}
