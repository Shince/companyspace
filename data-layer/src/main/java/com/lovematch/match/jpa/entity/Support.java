package com.lovematch.match.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Support extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String logoPath;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public Support() {
		super();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
