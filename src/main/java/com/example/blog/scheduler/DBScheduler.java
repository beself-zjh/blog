/** 
 * projectName: blog 
 * fileName: DBScheduler.java 
 * packageName: com.example.blog.scheduler 
 * date: Sep 9, 20204:13:09 PM 
 * copyright(c) 2017-2020 xxx公司
 */
package com.example.blog.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.blog.service.DBUpdateService;

/**
 * @title: DBScheduler.java
 * @package com.example.blog.scheduler
 * @description: update database per day (00:00:00).
 * @author: Zjh
 * @date: Sep 9, 2020 4:13:09 PM 
 * @version: V1.0   
 */
@Component
public class DBScheduler {

	@Autowired
	private DBUpdateService dbUpdateService;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void DBUpdateTask() {
		dbUpdateService.articleInfoUpdate();
	}

}
