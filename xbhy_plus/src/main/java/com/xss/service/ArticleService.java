package com.xss.service;

import com.github.pagehelper.PageInfo;
import com.xss.entity.Article;
import com.xss.service.BaseService;

import java.util.List;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
public interface ArticleService extends BaseService<Article>{

    PageInfo<Article> selectPage(Integer pageNum, Integer pageSize, String title);

    List<Article> addLook(Article article);

    List<Article> selectScSArticles();

    Article selectScSArticlesByAid(Integer id);

}
