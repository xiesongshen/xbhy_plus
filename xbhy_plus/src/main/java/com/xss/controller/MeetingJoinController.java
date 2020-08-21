package com.xss.controller;

import com.xss.entity.MeetingJoin;
import com.xss.entity.Result;
import com.xss.service.MeetingJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XSS
 * @date 2020/8/20
 * @desc
 */
@RestController
@RequestMapping("meetingJoin")
public class MeetingJoinController {

    @Autowired
    MeetingJoinService service;

    @RequestMapping("shouldMeetingJoin")
    public Result shouldMeetingJoin(Integer mid,Integer uid){
        MeetingJoin meetingJoin = new MeetingJoin();
        meetingJoin.setuId(uid);
        meetingJoin.setcId(mid);
        return new Result(true,"成功",service.selectOne(meetingJoin));
    }

    @RequestMapping("joinMeeting")
    public Result joinMeeting(Integer mid,Integer uid){
        MeetingJoin meetingJoin = new MeetingJoin();
        meetingJoin.setuId(uid);
        meetingJoin.setcId(mid);
        return new Result(true,"成功",service.insertSelective(meetingJoin));
    }

    @RequestMapping("delJoinMeeting")
    public Result delJoinMeeting(Integer mid,Integer uid){
        MeetingJoin meetingJoin = new MeetingJoin();
        meetingJoin.setuId(uid);
        meetingJoin.setcId(mid);
        return new Result(true,"成功",service.deleteByPrimaryKey(meetingJoin));
    }
}
