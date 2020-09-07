/** 
 * projectName: blog 
 * fileName: ArticleInfoRepository.java 
 * packageName: com.example.blog.repository 
 * date: Sep 7, 20202:25:36 PM 
 */
package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.domain.ArticleInfoEntity;

/**
 * @title: ArticleInfoRepository.java
 * @package com.example.blog.repository
 * @description: TODO
 * @author: Zjh
 * @date: Sep 7, 2020 2:25:36 PM 
 * @version: V1.0   
 */
public interface ArticleInfoRepository extends JpaRepository<ArticleInfoEntity, Integer> {

}
