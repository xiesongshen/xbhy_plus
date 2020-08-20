package com.xss.mapper;

import com.xss.entity.Userfocus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserFocusMapper extends Mapper<Userfocus> {


    @Select("SELECT " +
            "   userfocus.user_focus_id, " +
            "   count( 1 ) count  " +
            "FROM " +
            "   userfocus  " +
            "GROUP BY " +
            "   userfocus.user_focus_id " +
            "HAVING " +
            "   userfocus.user_focus_id =#{id}")
    Userfocus selectUserfocusCount(Integer id);
}