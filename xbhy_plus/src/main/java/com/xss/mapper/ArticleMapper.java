package com.xss.mapper;

import com.xss.entity.Article;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {

    @Select("SELECT " +
            "  *  " +
            "FROM " +
            "  article  " +
            "WHERE " +
            "  article.title LIKE CONCAT( '%', #{title}, '%' )")
    List<Article> selectByTitle(String title);


    @Select("SELECT " +
            "   a.*, " +
            "   count( * ) count  " +
            "FROM " +
            "   `user` u, " +
            "   article a, " +
            "   favorite f  " +
            "WHERE " +
            "   u.id = f.u_id  " +
            "   AND f.a_id = a.id  " +
            "GROUP BY " +
            "   a.id")
    List<Article> selectScSArticles();


    @Select("SELECT " +
            "   a.*, " +
            "   count( * ) count  " +
            "FROM " +
            "   `user` u, " +
            "   article a, " +
            "   favorite f  " +
            "WHERE " +
            "   u.id = f.u_id  " +
            "   AND f.a_id = a.id  " +
            "   AND a.id = #{id}  " +
            "GROUP BY " +
            "   a.id")
    Article selectScSArticlesByAid(Integer id);

}