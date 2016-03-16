package com.lovematch.match.service.competition;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lovematch.match.controller.common.defs.GlobalDefs;
import com.lovematch.match.jpa.entity.Competition;
import com.lovematch.match.jpa.repository.CompetitionRepository;

@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService {
	@Autowired
	private CompetitionRepository repository;

	@Override
	public Competition find(Long id) {

		return repository.findOne(id);
	}

	@Override
	public Competition create(Competition entity) {

		return repository.save(entity);
	}

	@Override
	public Competition update(Competition entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {

		repository.delete(id);
	}

	@Override
	public Page<Competition> findPageOrderById(int pageNumber, int pageSize, String order) {
		Pageable pageable;
		if (order.equals(GlobalDefs.DATE_ASC)) {
			pageable = new PageRequest(pageNumber, pageSize, Direction.ASC, "id");
		} else {
			pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		}
		return repository.findAll(pageable);
	}

	@Override
	public List<Competition> findList(String order) {

		return repository.findAll();
	}

	@Override
	public Page<Competition> findPageByType(String type, int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.DESC, "id");
		if (type != null && type.equals("all")) {
			return repository.findAll(pageable);
		} else {
			return repository.findAllByType(type, pageable);
		}
	}

	@Override
	public Page<Competition> findPageByCurrentDate(int pageNumber, int pageSize, Date currentDate) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.ASC, "startDate");
		Page<Competition> page = repository.findAllByCurrentDate(currentDate, pageable);
		return page;
	}

	@Override
	public Page<Competition> findPageByTypeAsc(String type, int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.ASC, "competitionStartDate");
		if (type != null && type.equals("all")) {
			return repository.findAll(pageable);
		} else {
			return repository.findAllByType(type, pageable);
		}
	}

	@Override
	public Page<Competition> findPageByFirstDateAndLastDate(int pageNumber,
			int pageSize, Date firstDate, Date lastDate) {
		Pageable pageable = new PageRequest(pageNumber, pageSize, Direction.ASC, "competitionStartDate");
		return repository.findAllByFirstDateAndLastDate(lastDate, firstDate, pageable);
	}

}
