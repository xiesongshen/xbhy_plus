package com.xss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.entity.Dept;
import com.xss.entity.Dept;
import com.xss.entity.Userfocus;
import com.xss.mapper.DeptMapper;
import com.xss.service.DeptService;
import com.xss.service.UserFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
@Service
@Transactional
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Autowired
    DeptMapper deptMapper;


    @Override
    public List<Dept> selectCount(){
        return deptMapper.selectDeptCount();
    }
    
}
