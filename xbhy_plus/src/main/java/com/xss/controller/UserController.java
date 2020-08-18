package com.xss.controller;

import com.xss.entity.Result;
import com.xss.entity.User;
import com.xss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XSS
 * @date 2020/8/14
 * @desc
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("toUser")
    public ModelAndView toUser(){
        return new ModelAndView("user");
    }

    @RequestMapping(value = "selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, String username) {

        return new Result(true, "查询成功", service.selectPage(pageNum, pageSize, username));
    }

    /*@RequestMapping("selectUser")
    public Result selectUser(User user){
    }*/

    @RequestMapping("toDetail")
    public ModelAndView toDetail(){
        return new ModelAndView("user_detail");
    }

    @RequestMapping("count")
    public Result count(){
        return new Result(true,"查询成功",service.userCount());
    }

    @RequestMapping("toUserFocus")
    public ModelAndView toUserFocus(){
        return new ModelAndView("my_user");
    }

    @RequestMapping("selectFocus/{pageNum}/{pageSize}")
    public Result selectFocus(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,Integer id){
        return new Result(true,"查询成功",service.selectFocus(pageNum,pageSize,id));
    }

    @RequestMapping("addLook")
    public Result addLook(@RequestBody User user){
        Integer look = user.getLook();
        look++;
        user.setLook(look);
        return new Result(true,"成功",service.addLook(user));
    }


    @RequestMapping("selectF")
    public Result selectF(Integer id){
        return new Result(true,"成功",service.selectFocus(id));
    }
}
