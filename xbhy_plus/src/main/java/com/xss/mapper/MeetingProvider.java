package com.xss.mapper;

import com.xss.entity.Meeting;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author XSS
 * @date 2020/8/20
 * @desc
 */
public class MeetingProvider {

    public String meetingList(Meeting meeting){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT  " +
                "   m.*, " +
                "   d.`name` deptN " +
                "FROM " +
                "   meeting m " +
                "   LEFT JOIN dept d ON m.dept_id = d.id " +
                "WHERE" +
                "   1=1 ");
        if (!StringUtils.isEmpty(meeting.getTitle())){
            sb.append("AND m.title like concat('%',#{title},'%') ");
        }

        if (!StringUtils.isEmpty(meeting.getStatus())){
            sb.append("AND m.`status` = #{status} ");
        }

        return sb.toString();
    }
}
