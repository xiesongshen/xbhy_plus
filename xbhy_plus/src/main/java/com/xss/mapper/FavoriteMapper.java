package com.xss.mapper;

import com.xss.entity.Article;
import com.xss.entity.Favorite;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FavoriteMapper extends Mapper<Favorite> {


    @Select("SELECT " +
            "   a.*  " +
            "FROM " +
            "   `user` u, " +
            "   article a, " +
            "   favorite f  " +
            "WHERE " +
            "   u.id = f.u_id  " +
            "   AND f.a_id = a.id  " +
            "   AND u.id = #{id}  " +
            "   AND a.title LIKE CONCAT( '%', #{title}, '%' )")
    List<Article> selectFavorite(@Param("id") Integer id, @Param("title") String title);
}