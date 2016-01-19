package com.lovematch.match.controller.admin.support;

import org.hibernate.validator.constraints.NotEmpty;

public class SupportForm {
 @NotEmpty
 private String name;
 private String url;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public SupportForm() {
	super();
}
 
}
