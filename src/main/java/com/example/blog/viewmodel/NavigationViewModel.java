package com.example.blog.viewmodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.example.blog.domain.ArticleInfoEntity;
import com.example.blog.domain.ConfigureEntity;
import com.example.blog.service.ArticleCollectService;

/**
 * @title: NavigationViewModel.java
 * @package com.example.blog.viewmodel
 * @description: binding with navigation frame.
 * @author: Zjh
 * @date: Sep 6, 2020 8:26:21 PM 
 * @version: V1.0   
 */
@Service
@EnableConfigurationProperties(ConfigureEntity.class)
public class NavigationViewModel {

	/**
	 * @Fields configureEntity : The global configuration information.
	 */
	@Autowired
	private ConfigureEntity configureEntity;
	
	@Autowired
	private ArticleCollectService articleCollectService;

	private String name;       //ConfigureEntity.name
	private String profession; //ConfigureEntity.profession
	private String email;      //ConfigureEntity.email
	private String avatarPath; //ConfigureEntity.avatarPath
	private String ageOfSite;  //calculate by ConfigureEntity.siteCreatedTime
	private List<ArticleInfoEntity> newArticles; //the newest 8 articles
	private List<String> labels; //no more than 10 labels
	
	public NavigationViewModel flush() {
		//update name
		setName(configureEntity.getName());
		
		//update profession
		setProfession(configureEntity.getProfession());

		//update email
		setEmail(configureEntity.getEmail());

		//update avatarPath
		setAvatarPath(configureEntity.getAvatarPath());

		//update newArticles
		setNewArticles(articleCollectService.findNewArticles(8));

		//update labels
		List<String> allLabels = articleCollectService.findAllLabel();
		setLabels(allLabels.subList(0, 10 <= allLabels.size() ? 10 : allLabels.size()));

		//update ageOfSite
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date siteCreatedTime = simpleDateFormat.parse(this.configureEntity.getSiteCreatedTime());
			Date now = new Date();
			setAgeOfSite((now.getTime() - siteCreatedTime.getTime()) / (24 * 60 * 60 * 1000) + " days");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public String getAgeOfSite() {
		return ageOfSite;
	}

	public void setAgeOfSite(String ageOfSite) {
		this.ageOfSite = ageOfSite;
	}

	public List<ArticleInfoEntity> getNewArticles() {
		return newArticles;
	}

	public void setNewArticles(List<ArticleInfoEntity> newArticles) {
		this.newArticles = newArticles;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
}
