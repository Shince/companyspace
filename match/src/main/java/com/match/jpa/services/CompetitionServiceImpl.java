package com.match.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.match.entities.Competition;
import com.match.jpa.repository.CompetitionRepository;

@Transactional
@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService {

	@Autowired
	private CompetitionRepository competitionRepository;
	
	
	@Override
	public Competition findOne(Long id) {
		return competitionRepository.findOne(id);
	}

	@Override
	public List<Competition> findAll() {
		return competitionRepository.findAll();
	}

	@Override
	public Competition create(Competition competition) {
		return competitionRepository.save(competition);
	}

	@Override
	public Competition update(Competition competition) {
		return competitionRepository.save(competition);
	}

}
