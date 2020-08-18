package com.xss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.entity.Article;
import com.xss.entity.Favorite;
import com.xss.mapper.ArticleMapper;
import com.xss.mapper.FavoriteMapper;
import com.xss.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
@Service
@Transactional
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite> implements FavoriteService {

    @Autowired
    FavoriteMapper favoriteMapper;

    @Override
    public PageInfo<Article> selectPage(Integer pageNum, Integer pageSize, Integer id, String title) {

        PageHelper.startPage(pageNum, pageSize);

        List<Article> list = favoriteMapper.selectFavorite(id, title);

        Page p = (Page) list;
        if (p.getPages() < pageNum) {
            PageHelper.startPage(1, pageSize);

            list = favoriteMapper.selectFavorite(id,title);
        }

        return new PageInfo<Article>(list);
    }

    @Override
    public List<Article> selectAllArticle(Integer id){
        return favoriteMapper.selectFavorite(id,"");
    }
}
