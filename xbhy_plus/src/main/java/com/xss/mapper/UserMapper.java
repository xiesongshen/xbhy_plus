package com.xss.mapper;

import com.xss.entity.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Select("SELECT " +
            "  *  " +
            "FROM " +
            "  `user`  " +
            "WHERE " +
            "  `user`.username LIKE CONCAT( '%', #{username}, '%' )")
    public List<User> selectByName(String username);


    @Select("SELECT COUNT(1) from `user`")
    Integer userCount();

    @Select("SELECT " +
            "    ufr.*  " +
            "FROM " +
            "    `user` u, " +
            "    userfocus uf, " +
            "    `user` ufr  " +
            "WHERE " +
            "    u.id = uf.user_id  " +
            "    AND uf.user_focus_id = ufr.id  " +
            "    AND u.id =#{id}")
    List<User> selectFocus(Integer id);

}