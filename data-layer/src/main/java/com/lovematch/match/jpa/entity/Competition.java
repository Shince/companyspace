package com.lovematch.match.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Competition extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String type = "roadrace"; // road race, bicycle or other types of competition for further.
	private String title;
	private String postDate; // the competition post date.
	@Lob
	private String description;
	private String officialWebsite; // url link for the competition official website.
	private String enrollLinke; // url link for enroll the competition.
	private String picPath; // the picture used in this post.
	private Date startDate; // enroll start date
	private Date endDate; // enroll end date
	private String competitionStartDate;
	
	
	public String getCompetitionStartDate() {
		return competitionStartDate;
	}

	public void setCompetitionStartDate(String competitionStartDate) {
		this.competitionStartDate = competitionStartDate;
	}

	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getOfficialWebsite() {
		return officialWebsite;
	}

	public void setOfficialWebsite(String officialWebsite) {
		this.officialWebsite = officialWebsite;
	}

	public String getEnrollLinke() {
		return enrollLinke;
	}

	public void setEnrollLinke(String enrollLinke) {
		this.enrollLinke = enrollLinke;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

}