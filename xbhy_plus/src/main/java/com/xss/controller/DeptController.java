package com.xss.controller;

import com.xss.entity.Result;
import com.xss.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XSS
 * @date 2020/8/15
 * @desc
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    DeptService service;

    @RequestMapping("toDept")
    public ModelAndView toDept(){
        return new ModelAndView("department");
    }

    @RequestMapping("selectCount")
    public Result selectCount(){
        return new Result(true,"查询成功",service.selectCount());
    }

    @RequestMapping("findAllDept")
    public Result finAllDept(){
        return new Result(true,"成功",service.selectAll());
    }
}
