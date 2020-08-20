package com.xss.service;

import com.github.pagehelper.PageInfo;
import com.xss.entity.User;

import java.util.List;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
public interface UserService extends BaseService<User>{
    PageInfo<User> selectPage(Integer pageNum, Integer pageSize, String username);


    Integer userCount();

    PageInfo<User> selectFocus(Integer pageNum, Integer pageSize, Integer id);

    List<User> addLook(User user);

    List<User> selectFocus(Integer id);

    List<User> selectFocusByid(Integer id);

    List<User> selectMyUserSc(Integer aid, Integer uid);
}
