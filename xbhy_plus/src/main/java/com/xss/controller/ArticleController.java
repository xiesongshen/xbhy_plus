package com.xss.controller;

import com.xss.entity.Article;
import com.xss.entity.Result;
import com.xss.entity.User;
import com.xss.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author XSS
 * @date 2020/8/15
 * @desc
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    ArticleService service;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("toArticle")
    public ModelAndView toArticle(){
        return new ModelAndView("article");
    }

    @RequestMapping(value = "selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, String title) {

        return new Result(true, "查询成功", service.selectPage(pageNum, pageSize, title));
    }

    @RequestMapping("toDetail")
    public ModelAndView toDetail(){
        return new ModelAndView("article_detail");
    }

    @RequestMapping("toInsert")
    public ModelAndView toInsert(){
        return new ModelAndView("article_add");
    }

    @RequestMapping(value = "doInsert",method = RequestMethod.POST)
    public Result doInsert(@RequestBody Article article){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        article.setPublishDate(new Date());
        article.setPublishRealName(loginUser.getRealName());
        return new Result(true,"添加成功",service.insert(article));
    }

    @RequestMapping("addLook")
    public Result addLook(@RequestBody Article article){
        Integer look = article.getBrowseCount();
        look++;
        article.setBrowseCount(look);

        return new Result(true,"成功",service.addLook(article));
    }

    @RequestMapping("scArticle")
    public Result scArticle(){

        return new Result(true,"成功",service.selectScSArticles());
    }

    @RequestMapping("selectScSArticlesByAid")
    public Result selectScSArticlesByAid(Integer id){
        Article article = service.selectScSArticlesByAid(id);
        if (article==null){
            article.setCount(0);
        }
        return new Result(true,"成功",article);
    }


}
