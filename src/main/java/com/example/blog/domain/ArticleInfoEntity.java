package com.example.blog.domain;

import javax.persistence.*;

@Entity(name="articleinfo")
public class ArticleInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String filename;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ArticleInfo {" + "id=" + id + "filename=" + filename + "}";
	}
}
