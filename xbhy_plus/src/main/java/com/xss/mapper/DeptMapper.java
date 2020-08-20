package com.xss.mapper;

import com.xss.entity.Dept;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DeptMapper extends Mapper<Dept> {


    @Select("SELECT " +
            "   dept.*, " +
            "   count( dept_id ) count  " +
            "FROM " +
            "   dept " +
            "   LEFT JOIN `user` ON `user`.dept_id = dept.id  " +
            "GROUP BY " +
            "   dept.id")
    List<Dept> selectDeptCount();

}