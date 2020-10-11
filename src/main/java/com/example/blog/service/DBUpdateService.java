/** 
 * projectName: blog 
 * fileName: DBUpdateService.java 
 * packageName: com.example.blog.service 
 * date: Sep 9, 20204:23:17 PM 
 * copyright(c) 2017-2020 xxx公司
 */
package com.example.blog.service;

import org.springframework.stereotype.Service;

/**
 * @title: DBUpdateService.java
 * @package com.example.blog.service
 * @description: update database service.
 * @author: Zjh
 * @date: Sep 9, 2020 4:23:17 PM 
 * @version: V1.0   
 */
@Service
public interface DBUpdateService {
	
	
	/**
	 *@title: articleInfoUpdate 
	 *@description: update table 'articleInfo'.
	 */
	public void articleInfoUpdate();
	
}
