package com.xss.controller;

import com.xss.entity.Favorite;
import com.xss.entity.Result;
import com.xss.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XSS
 * @date 2020/8/15
 * @desc
 */
@RestController
@RequestMapping("favorite")
public class FavoriteController {

    @Autowired
    FavoriteService service;

    @RequestMapping("toCollect")
    public ModelAndView toCollect() {
        return new ModelAndView("article_collect");
    }

    @RequestMapping(value = "selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, Integer id, String title) {

        return new Result(true, "查询成功", service.selectPage(pageNum, pageSize, id, title));
    }

    @RequestMapping("selectAll")
    public Result selectAll(Integer id){
        return new Result(true,"查询成功",service.selectAllArticle(id));
    }

    @RequestMapping("addSC")
    public Result addSC(Integer uid,Integer aid){
        Favorite favorite = new Favorite();
        favorite.setaId(aid);
        favorite.setuId(uid);
        return new Result(true,"收藏成功",service.insertSelective(favorite));
    }

    @RequestMapping("delSC")
    public Result delSC(Integer uid,Integer aid){
        Favorite favorite = new Favorite();
        favorite.setaId(aid);
        favorite.setuId(uid);

        return new Result(true,"取消收藏成功",service.delete(favorite));
    }
}
