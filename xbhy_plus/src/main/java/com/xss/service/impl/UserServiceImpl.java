package com.xss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.entity.User;
import com.xss.mapper.UserMapper;
import com.xss.service.UserService;
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
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<User> selectPage(Integer pageNum,Integer pageSize,String username){
        PageHelper.startPage(pageNum,pageSize);

        List<User> users = userMapper.selectByName(username);

        Page p = (Page) users;
        if (p.getPages() < pageNum) {
            PageHelper.startPage(1, pageSize);

            users = userMapper.selectByName(username);
        }

        return new PageInfo<User>(users);
    }

    @Override
    public Integer userCount() {
        return userMapper.userCount();
    }

    @Override
    public PageInfo<User> selectFocus(Integer pageNum,Integer pageSize,Integer id){
        PageHelper.startPage(pageNum,pageSize);

        List<User> users = userMapper.selectFocus(id);

        Page p = (Page) users;
        if (p.getPages() < pageNum) {
            PageHelper.startPage(1, pageSize);

            users = userMapper.selectFocus(id);
        }

        return new PageInfo<User>(users);
    }

    @Override
    public List<User> addLook(User user){
        userMapper.updateByPrimaryKeySelective(user);

        return userMapper.select(user);
    }


    @Override
    public List<User> selectFocus(Integer id){
        return userMapper.selectFocus(id);
    }


    @Override
    public List<User> selectFocusByid(Integer id){
        return userMapper.selectFocusByid(id);
    }

    @Override
    public List<User> selectMyUserSc( Integer aid, Integer uid){
        return userMapper.selectMyUserSc(aid,uid);
    }
}
