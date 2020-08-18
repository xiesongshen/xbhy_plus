package com.xss.service;


import com.github.pagehelper.PageInfo;
import com.xss.entity.Article;
import com.xss.entity.Favorite;

import java.util.List;


/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
public interface FavoriteService extends BaseService<Favorite>{

    PageInfo<Article> selectPage(Integer pageNum, Integer pageSize, Integer id, String title);

    List<Article> selectAllArticle(Integer id);
}
