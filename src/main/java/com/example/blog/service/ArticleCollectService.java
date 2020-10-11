/** 
 * projectName: blog 
 * fileName: ArticleColletService.java 
 * packageName: com.example.blog.service 
 * date: Sep 7, 20202:18:00 PM 
 */
package com.example.blog.service;

import java.util.List;
import java.util.Map;

import com.example.blog.domain.ArticleInfoEntity;

/**
 * @title: ArticleColletService.java
 * @package com.example.blog.service
 * @description: TODO
 * @author: Zjh
 * @date: Sep 7, 2020 2:18:00 PM
 * @version: V1.0
 */
public interface ArticleCollectService {

	/**
	 * @title: findAll
	 * @description: get all article information from database.
	 * @return List<ArticleInfoEntity> - all articleInfo in database
	 */
	public List<ArticleInfoEntity> findAll();

	/**
	 * @title: findAllSortByLabel
	 * @description: get all article information from database and classify them by
	 *               label.
	 * @return Map<String, List<ArticleInfoEntity>> - all articleInfo classified by
	 *         label.
	 */
	public Map<String, List<ArticleInfoEntity>> findAllSortedByLabel(String label);

	/**
	 * @title: findNewArticles
	 * @description: sort articles by date.
	 * @param num: return the first 'num' article info.
	 * @return List<ArticleInfoEntity> - the first 'num' article info
	 */
	public List<ArticleInfoEntity> findNewArticles(int num) throws IndexOutOfBoundsException;

	/**
	 * @title: findAllLabel
	 * @description: get all the label of articles.
	 * @return List<String> - all label
	 */
	public List<String> findAllLabel();

	public List<String> findAllDate();

	public List<ArticleInfoEntity> findByLabel(String label);

	public List<ArticleInfoEntity> findByDate(String date);
}
