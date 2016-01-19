package com.lovematch.match.service.sharinginfo;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lovematch.match.jpa.entity.SharingInfo;
import com.lovematch.match.service.BaseService;

public interface SharingInfoService extends BaseService<SharingInfo> {
	List<SharingInfo> findList();
	Page<SharingInfo> findPageOrderByDate(int pageNumber,int pageSize, String order);
}
