package com.xss.controller;

import com.xss.entity.Meeting;
import com.xss.entity.Result;
import com.xss.entity.User;
import com.xss.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

/**
 * @author XSS
 * @date 2020/8/20
 * @desc
 */
@RestController
@RequestMapping("meeting")
public class MeetingController {

    @Autowired
    MeetingService service;

    @RequestMapping("toMeeting")
    public ModelAndView toMeeting() {
        return new ModelAndView("meeting");
    }


    @RequestMapping("selectMeeting/{pageNum}/{pageSize}")
    public Result selectFocus(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,@RequestBody Meeting meeting){
        return new Result(true,"查询成功",service.selectMeeting(pageNum,pageSize,meeting));
    }

    @RequestMapping("toDetail")
    public ModelAndView toDetail(){
        return new ModelAndView("meeting_detail");
    }

    @RequestMapping("selectShouldJoin")
    public Result selectShouldJoin(Integer mid){
        return new Result(true,"成功",service.selectShouldJoin(mid));
    }

    @RequestMapping("toInsert")
    public ModelAndView toInsert(){
        return new ModelAndView("meeting_add");
    }


    @RequestMapping("doInsert")
    public Result doInsert(@RequestBody Meeting meeting){
        meeting.setMakeUser(Arrays.toString(meeting.getJoinUser()));
        meeting.setPublishDate(new Date());
        meeting.setStatus(0);
        return new Result(true,"发布成功",service.insertSelective(meeting));
    }

    @RequestMapping("count")
    public Result count(){
        return new Result(true,"查询成功",service.selectCount(null));
    }

}

