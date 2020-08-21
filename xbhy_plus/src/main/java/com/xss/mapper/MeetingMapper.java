package com.xss.mapper;

import com.xss.entity.Meeting;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MeetingMapper extends Mapper<Meeting> {


    @SelectProvider(value = MeetingProvider.class,method = "meetingList")
    List<Meeting> meetingList(Meeting meeting);


    @Select("SELECT " +
            "   u.*  " +
            "FROM " +
            "   `user` u, " +
            "   meeting m, " +
            "   meeting_join mj  " +
            "WHERE " +
            "   u.id = mj.u_id  " +
            "   AND mj.c_id = m.id " +
            "   AND m.id = #{mid} ")
    List<Meeting> selectShouldJoin(Integer mid);
}