package com.xss.mapper;

import com.xss.entity.Dept;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DeptMapper extends Mapper<Dept> {


    @Select("SELECT " +
            "   count( * ) count, " +
            "   dept.*  " +
            "FROM " +
            "   `user`, " +
            "   dept  " +
            "WHERE " +
            "   `user`.dept_id = dept.id  " +
            "GROUP BY " +
            "   dept.id")
    List<Dept> selectDeptCount();
}