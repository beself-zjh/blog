package com.example.blog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.domain.ArticleInfoEntity;
import com.example.blog.repository.ArticleInfoRepository;
import com.example.blog.service.ArticleCollectService;

@Service
public class ArticleCollectServiceImpl implements ArticleCollectService {

	@Autowired
	private ArticleInfoRepository articleInfoRepository;

	/**
	 * @title: findAll
	 * @description: get all article information from database.
	 * @return List<ArticleInfoEntity> - all articleInfo in database
	 */
	@Override
	public List<ArticleInfoEntity> findAll() {
		return articleInfoRepository.findAll();
	}

	/**
	 * @title: findAllSortByLabel
	 * @description: get all article information from database and classify them by
	 *               label.
	 * @return Map<String, List<ArticleInfoEntity>> - all articleInfo classified by
	 *         label.
	 * @see com.example.blog.service.ArticleCollectService#findAllSortByLabel()
	 */
	@Override
	public Map<String, List<ArticleInfoEntity>> findAllSortedByLabel(String label) {
		Map<String, List<ArticleInfoEntity>> map = new HashMap<String, List<ArticleInfoEntity>>();
		List<ArticleInfoEntity> allArticleInfo = articleInfoRepository.findAll();
		allArticleInfo.forEach(item -> {
			if (map.containsKey(item.getLabel())) {
				map.get(item.getLabel()).add(item);
			} else {
				if (label == null || item.getLabel().equals(label)) {
					List<ArticleInfoEntity> tempList = new ArrayList<ArticleInfoEntity>();
					tempList.add(item);
					map.put(item.getLabel(), tempList);
				}
			}
		});
		return map;
	}

	/**
	 * @title: findNewArticles
	 * @description: sort articles by date.
	 * @param num: the number of article you want to get.
	 * @return List<ArticleInfoEntity> - the first 'num' article info
	 */
	@Override
	public List<ArticleInfoEntity> findNewArticles(int num) throws IndexOutOfBoundsException {
		// num can't less than zero
		if (num < 0)
			throw new IndexOutOfBoundsException();

		// sort by date
		List<ArticleInfoEntity> allArticleInfo = articleInfoRepository.findAll();
		allArticleInfo
				.sort((ArticleInfoEntity item1, ArticleInfoEntity item2) -> item1.getDate().compareTo(item2.getDate()));

		return allArticleInfo.subList(0, num <= allArticleInfo.size() ? num : allArticleInfo.size());
	}

	/**
	 * @title: findAllLabel
	 * @description: get all the label of articles.
	 * @return List<String> - all label
	 */
	@Override
	public List<String> findAllLabel() {
		List<ArticleInfoEntity> allArticleInfo = articleInfoRepository.findAll();
		List<String> allLabel = new ArrayList<>();
		allArticleInfo.forEach(item -> {
			if (!allLabel.contains(item.getLabel()))
				allLabel.add(item.getLabel());
		});

		return allLabel;
	}

	/**
	 * @title: findAllDate
	 * @description: TODO
	 * @return
	 * @see com.example.blog.service.ArticleCollectService#findAllDate()
	 */
	@Override
	public List<String> findAllDate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * @title: findByLabel
	 * @description: TODO
	 * @param label
	 * @return
	 * @see com.example.blog.service.ArticleCollectService#findByLabel(java.lang.String)
	 */
	@Override
	public List<ArticleInfoEntity> findByLabel(String label) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * @title: findByDate
	 * @description: TODO
	 * @param date
	 * @return
	 * @see com.example.blog.service.ArticleCollectService#findByDate(java.lang.String)
	 */
	@Override
	public List<ArticleInfoEntity> findByDate(String date) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
