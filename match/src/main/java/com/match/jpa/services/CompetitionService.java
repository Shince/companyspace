package com.match.jpa.services;

import java.util.List;

import com.match.entities.Competition;

public interface CompetitionService {
	Competition findOne(Long id);
	List<Competition> findAll();
	Competition create(Competition competition);
	Competition update(Competition competition);
}
