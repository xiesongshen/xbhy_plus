package com.xss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xss.entity.Meeting;

import com.xss.enums.Sysenum;
import com.xss.mapper.MeetingMapper;
import com.xss.service.MeetingService;
import com.xss.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
@Service
@Transactional
public class MeetingServiceImpl extends BaseServiceImpl<Meeting> implements MeetingService {

    @Autowired
    MeetingMapper meetingMapper;

    @Override
    public PageInfo<Meeting> selectMeeting(Integer pageNum, Integer pageSize, Meeting meeting) {
        PageHelper.startPage(pageNum, pageSize);

        List<Meeting> list = meetingMapper.meetingList(meeting);

        Page p = (Page) list;
        if (p.getPages() < pageNum) {
            PageHelper.startPage(1, pageSize);

            list = meetingMapper.meetingList(meeting);
        }

        return new PageInfo<Meeting>(list);
    }


    @Override
    public void updateStatusTask() {
        List<Meeting> list = meetingMapper.meetingList(new Meeting());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Meeting meeting : list) {
            //当前时间戳
            long currentTime = new Date().getTime();
            long startTime = DateUtil.getTimeByStr(sdf.format(meeting.getStartTime()));
            long endTime = DateUtil.getTimeByStr(sdf.format(meeting.getEndTime()));

            if (startTime <= currentTime) {
                if (endTime > currentTime) {
                    //会议正在进行中
                    meeting.setStatus(Sysenum.DOING.getValue());
                    meetingMapper.updateByPrimaryKeySelective(meeting);
                } else {
                    //会议已经结束
                    meeting.setStatus(Sysenum.END.getValue());
                    meetingMapper.updateByPrimaryKeySelective(meeting);
                }
            } else {
                //会议未开始，不需要处理
            }
        }
    }

    @Override
    public List<Meeting> selectShouldJoin(Integer mid){
        return meetingMapper.selectShouldJoin(mid);
    }

}
