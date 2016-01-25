package com.lovematch.match.jpa.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author 
 *
 */
@Entity
public class WebCont extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//学术论文(xslw) 研究报告(yjbg) 出版书籍(cbsj) 专利授权(zlsq) 研究课题(yjkt)
	private String type = "xslw";
	private String photo_path;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String title;
	@Lob
	private String content;
	
	private String subTitle;
	
	@DateTimeFormat(style="yyyy-MM-dd hh:mm")
	private Date date;

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
	public WebCont() {
		super();
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	
}
