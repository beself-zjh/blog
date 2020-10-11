/** 
 * projectName: blog 
 * fileName: CatalogViewModel.java 
 * packageName: com.example.blog.viewmodel 
 * date: Sep 10, 20201:51:14 PM 
 * copyright(c) 2017-2020 xxx公司
 */
package com.example.blog.viewmodel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.domain.ArticleInfoEntity;
import com.example.blog.service.ArticleCollectService;

/**
 * @title: CatalogViewModel.java
 * @package com.example.blog.viewmodel
 * @description: binding with catalog page.
 * @author: Zjh
 * @date: Sep 10, 2020 1:51:14 PM 
 * @version: V1.0   
 */
@Service
public class CatalogViewModel {
	
	@Autowired
	private ArticleCollectService articleCollectService;
	
	private Map<String, List<ArticleInfoEntity>> catalog;

	public CatalogViewModel flush(String label) {
		setCatalog(articleCollectService.findAllSortedByLabel(label));
		
		return this;
	}
	
	public Map<String, List<ArticleInfoEntity>> getCatalog() {
		return catalog;
	}

	public void setCatalog(Map<String, List<ArticleInfoEntity>> catalog) {
		this.catalog = catalog;
	}

}
