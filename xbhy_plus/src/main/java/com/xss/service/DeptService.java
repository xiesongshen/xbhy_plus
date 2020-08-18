package com.xss.service;

import com.xss.entity.Dept;

import java.util.List;

/**
 * @author XSS
 * @date 2020/8/15
 * @desc
 */
public interface DeptService extends BaseService<Dept>{

    List<Dept> selectCount();
}
