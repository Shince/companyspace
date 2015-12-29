package com.match.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {
	
	@NotEmpty
	private String userName;
	
	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}
	
}
