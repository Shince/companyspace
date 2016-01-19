package com.lovematch.match.jpa.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 新闻
 * @author lianghejun
 *
 */
@Entity
public class WebNews extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	@Lob
	private String content;
	@DateTimeFormat(style="yyyy-MM-dd hh:mm")
	private Date date;
	
	private String photo_path;
	// zhxw(综合新闻); hyzx(行业资讯); yjdt(研究动态); 
	private String type = "zhxw";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public WebNews() {
		super();
	}

	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
}
