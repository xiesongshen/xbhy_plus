package com.xss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.entity.Article;
import com.xss.mapper.ArticleMapper;
import com.xss.service.ArticleService;
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
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> selectPage(Integer pageNum, Integer pageSize, String title) {

        PageHelper.startPage(pageNum, pageSize);

        List<Article> list = articleMapper.selectByTitle(title);

        Page p = (Page) list;
        if (p.getPages() < pageNum) {
            PageHelper.startPage(1, pageSize);

            list = articleMapper.selectByTitle(title);
        }

        return new PageInfo<Article>(list);
    }

    @Override
    public List<Article> addLook(Article article){
        articleMapper.updateByPrimaryKeySelective(article);

        return articleMapper.select(article);
    }


    @Override
    public List<Article> selectScSArticles(){
        return articleMapper.selectScSArticles();
    }

    @Override
    public Article selectScSArticlesByAid(Integer id){
        return articleMapper.selectScSArticlesByAid(id);
    }


}
