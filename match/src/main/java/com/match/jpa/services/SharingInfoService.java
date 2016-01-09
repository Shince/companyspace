package com.match.jpa.services;

import java.util.List;

import com.match.entities.SharingInfo;

public interface SharingInfoService {
	SharingInfo findOne(Long id);
	List<SharingInfo> findAll();
	SharingInfo create(SharingInfo sharing);
	SharingInfo update(SharingInfo sharing);
}
