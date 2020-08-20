package com.xss.service;


import com.github.pagehelper.PageInfo;
import com.xss.entity.Meeting;



/**
 * @author XSS
 * @date 2020/8/15
 * @desc
 */
public interface MeetingService extends BaseService<Meeting>{


    PageInfo<Meeting> selectMeeting(Integer pageNum, Integer pageSize, Meeting meeting);

    void updateStatusTask();
}
