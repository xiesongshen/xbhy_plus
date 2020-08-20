package com.xss.mapper;

import com.xss.entity.Meeting;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MeetingMapper extends Mapper<Meeting> {


    @SelectProvider(value = MeetingProvider.class,method = "meetingList")
    public List<Meeting> meetingList(Meeting meeting);
}