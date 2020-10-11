package com.example.blog.domain;

import javax.persistence.*;

@Entity(name="articleinfo")
public class ArticleInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String date;
	private String label;
	
	public ArticleInfoEntity() {}
	
	public ArticleInfoEntity(Integer id, String date, String label, String title) {
		this.id = id;
		this.date = date;
		this.label = label;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ArticleInfo {" + id + "_" + date + "_" + label + "_" + title + "}";
	}
}
