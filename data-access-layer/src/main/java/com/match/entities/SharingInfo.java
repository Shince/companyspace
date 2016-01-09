package com.match.entities;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class SharingInfo extends AbstractEntity {

	/**
	 * for the experience sharing module
	 */
	private static final long serialVersionUID = 1L;
	
	private String type; // reserved field.
	private String title;
	private String postDate;
	@Lob
	private String content;
	private String picPath; // the picture used in this post.
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
}