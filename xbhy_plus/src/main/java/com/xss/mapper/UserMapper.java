package com.xss.mapper;

import com.xss.entity.User;
import org.apache.ibatis.annotations.Param;
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


    @Select("SELECT " +
            "   u.*  " +
            "FROM " +
            "   userfocus uf, " +
            "   `user` u  " +
            "WHERE " +
            "   uf.user_focus_id = u.id  " +
            "   AND uf.user_id =#{id}")
    List<User> selectFocusByid(Integer id);


    @Select("SELECT  " +
            "uf.*  " +
            "FROM " +
            "(SELECT " +
            "   u.*  " +
            "FROM " +
            "   favorite f, " +
            "   `user` u  " +
            "WHERE " +
            "   u.id = f.u_id  " +
            "   AND f.a_id = #{aid}) u, " +
            "   (SELECT " +
            "   u.*  " +
            "FROM " +
            "   favorite f, " +
            "   `user` u  " +
            "WHERE " +
            "   u.id = f.u_id  " +
            "   AND f.a_id = #{aid}) uf, " +
            "   userfocus ufs " +
            "   WHERE " +
            "   u.id = ufs.user_id " +
            "   AND " +
            "   ufs.user_focus_id = uf.id " +
            "   AND " +
            "   u.id = #{uid}")
    List<User> selectMyUserSc(@Param("aid") Integer aid,@Param("uid") Integer uid);

}