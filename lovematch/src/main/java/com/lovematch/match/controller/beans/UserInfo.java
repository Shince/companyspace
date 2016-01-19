package com.lovematch.match.controller.beans;

import com.lovematch.match.jpa.entity.User;




public class UserInfo {

	private User user;

	//private Announcement announcement;

	public UserInfo(User user) {
		this.user = user;
	
	}

	public Long getId() {
		return this.user.getId();
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName(){
		return this.user.getName();
	}
	
	
	public UserInfo() {
		super();
	}
}
