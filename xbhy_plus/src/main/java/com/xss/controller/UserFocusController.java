package com.xss.controller;

import com.xss.entity.Result;
import com.xss.entity.Userfocus;
import com.xss.service.UserFocusService;
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
@RequestMapping("userFocus")
public class UserFocusController {

    @Autowired
    UserFocusService service;

    @RequestMapping("delFocus")
    public Result delFocus(Integer userFocusId,Integer userId){
        Userfocus userfocus = new Userfocus();
        userfocus.setUserFocusId(userFocusId);
        userfocus.setUserId(userId);
        return new Result(true,"取消关注",service.delete(userfocus));
    }

    @RequestMapping("addFocus")
    public Result addFocus(Integer uid,Integer userFocusId){
        Userfocus userfocus = new Userfocus();
        userfocus.setUserId(uid);
        userfocus.setUserFocusId(userFocusId);
        return new Result(true,"成功关注",service.insert(userfocus));
    }

    @RequestMapping("selectFocus")
    public Result selectFocus(Integer uid){
        Userfocus userfocus = new Userfocus();
        userfocus.setUserId(uid);
        return new Result(true,"查询成功",service.select(userfocus));
    }
}
