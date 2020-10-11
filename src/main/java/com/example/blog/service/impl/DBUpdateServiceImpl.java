/** 
 * projectName: blog 
 * fileName: DBUpdateServiceImpl.java 
 * packageName: com.example.blog.service.impl 
 * date: Sep 9, 20204:32:25 PM 
 * copyright(c) 2017-2020 xxx公司
 */
package com.example.blog.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.domain.ArticleInfoEntity;
import com.example.blog.domain.ConfigureEntity;
import com.example.blog.repository.ArticleInfoRepository;
import com.example.blog.service.DBUpdateService;

/**
 * @title: DBUpdateServiceImpl.java
 * @package com.example.blog.service.impl
 * @description: TODO
 * @author: Zjh
 * @date: Sep 9, 2020 4:32:25 PM
 * @version: V1.0
 */
@Service
public class DBUpdateServiceImpl implements DBUpdateService {

	@Autowired
	private ConfigureEntity configureEntity;

	@Autowired
	private ArticleInfoRepository articleInfoRepository;

	/**
	 * @title: articleInfoUpdate
	 * @description: update table 'articleInfo'.
	 * @see com.example.blog.service.DBUpdateService#articleInfoUpdate()
	 */
	@Override
	public void articleInfoUpdate() {
		File directory = new File(configureEntity.getArticleDirPath());
		if (!directory.isDirectory()) {
			// TODO Warning : config.articleDirPath is wrong.
			return;
		}

		File[] files = directory.listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				// update into database
				String[] filename = file.getName().split("\\."); 
				String[] fileInfo = filename[0].split("_");
				if (fileInfo.length != 4 || !filename[1].equals("md"))
					break;// TODO record into log
				ArticleInfoEntity articleInfo = new ArticleInfoEntity(Integer.parseInt(fileInfo[0]), 
						fileInfo[1], fileInfo[2], fileInfo[3]);
				articleInfoRepository.save(articleInfo);
			}
		}//TODO delete operate
	}

}
