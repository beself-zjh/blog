/** 
 * projectName: blog 
 * fileName: ArticleViewModel.java 
 * packageName: com.example.blog.viewmodel 
 * date: Sep 10, 202011:03:21 AM 
 * copyright(c) 2017-2020 xxx公司
 */
package com.example.blog.viewmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.domain.ConfigureEntity;
import com.example.blog.service.FileReadService;

/**
 * @title: ArticleViewModel.java
 * @package com.example.blog.viewmodel
 * @description: binding with article page.
 * @author: Zjh
 * @date: Sep 10, 2020 11:03:21 AM 
 * @version: V1.0   
 */
@Service
public class ArticleViewModel {

	@Autowired
	private ConfigureEntity configureEntity;
	
	@Autowired
	private FileReadService fileReadService;
	
	private String markdown;

	public ArticleViewModel flush(String filename) {
		setMarkdown(fileReadService.mdFileRead(configureEntity.getArticleDirPath() + "\\" + filename + ".md"));
		
		return this;
	}
	
	public String getMarkdown() {
		return markdown;
	}
	
	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}


}
