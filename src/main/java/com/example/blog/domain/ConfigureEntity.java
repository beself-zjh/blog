package com.example.blog.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @title: ConfigureEntity.java
 * @package com.example.blog.domain
 * @description: Global configuration information from application.properties.
 * @author: Zjh
 * @date: Sep 6, 2020 8:37:35 PM 
 * @version: V1.0   
 */
@ConfigurationProperties(prefix="config")
public class ConfigureEntity {
	
	/**
	 * @Fields siteCreatedTime : The time the site was created.
	 */
	private String siteCreatedTime;

	public String getSiteCreatedTime() {
		return siteCreatedTime;
	}

	public void setSiteCreatedTime(String siteCreatedTime) {
		this.siteCreatedTime = siteCreatedTime;
	}
	
}
