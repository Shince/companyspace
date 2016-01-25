package com.lovematch.match.jpa.entity;


import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Product extends AbstractEntity {
	 
	/**
	 * Related product for the match, such as hotel, traffic solution, etc. 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	@Lob
	private String description;
	private String type;
	private String photo_url;
	@ManyToOne
	private Competition competition;
	
	
	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

}