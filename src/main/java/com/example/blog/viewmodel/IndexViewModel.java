package com.example.blog.viewmodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.example.blog.domain.ConfigureEntity;

/**
 * @title: IndexViewModel.java
 * @package com.example.blog.viewmodel
 * @description: Parse the dynamic data of the Index page.
 * @author: Zjh
 * @date: Sep 6, 2020 8:26:21 PM 
 * @version: V1.0   
 */
@Service
@EnableConfigurationProperties(ConfigureEntity.class)
public class IndexViewModel {

	/**
	 * @Fields configureEntity : The global configuration information.
	 */
	@Autowired
	ConfigureEntity configureEntity;

	/**
	 * @Fields ageOfSite : The age of site.(unit: day)
	 */
	private String ageOfSite;

	/**
	 *@title: getAgeOfSite 
	 *@description: The getter of variable 'ageOfSite', update the value of 'ageOfSite' when called.
	 *@throws: ParseException
	 */
	public String getAgeOfSite() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date siteCreatedTime = simpleDateFormat.parse(this.configureEntity.getSiteCreatedTime());
			Date now = new Date();
			ageOfSite = (now.getTime() - siteCreatedTime.getTime()) / (24 * 60 * 60 * 1000) + " days";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ageOfSite;
	}

	/**
	 *@title: setAgeOfSite 
	 *@description: The setter of variable 'ageOfSite', this method can't be used.
	 *@param ageOfSite
	 */
	public void setAgeOfSite(String ageOfSite) {
		System.err.println("WARN: varable 'ageOfSite' can't be set!");		
	}
	
}
