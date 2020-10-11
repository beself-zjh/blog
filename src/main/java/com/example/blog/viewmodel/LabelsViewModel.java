/** 
 * projectName: blog 
 * fileName: LabelViewModel.java 
 * packageName: com.example.blog.viewmodel 
 * date: Sep 10, 20203:36:19 PM 
 * copyright(c) 2017-2020 xxx公司
 */
package com.example.blog.viewmodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.service.ArticleCollectService;

/**
 * @title: LabelsViewModel.java
 * @package com.example.blog.viewmodel
 * @description: binding with labels page.
 * @author: Zjh
 * @date: Sep 10, 2020 3:36:19 PM 
 * @version: V1.0   
 */
@Service
public class LabelsViewModel {
	
	@Autowired
	private ArticleCollectService articleCollectService;
	
	private List<String> labels;

	public LabelsViewModel flush() {
		//update labels
		setLabels(articleCollectService.findAllLabel());
		
		return this;
	}
	
	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
}
