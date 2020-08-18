package com.xss.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author XSS
 * @date 2020/7/17
 * @desc
 */
@Controller
@RequestMapping("common")
public class CommonController {


    @RequestMapping("header")
    public String navbar(){

        return "common/header";
    }

    @RequestMapping("sidebar")
    public String sidebar(){

        return "common/sidebar";
    }



}
