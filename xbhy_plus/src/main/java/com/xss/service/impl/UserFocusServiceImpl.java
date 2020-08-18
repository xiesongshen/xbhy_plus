package com.xss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.entity.User;
import com.xss.entity.Userfocus;
import com.xss.mapper.UserFocusMapper;
import com.xss.mapper.UserMapper;
import com.xss.service.UserFocusService;
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
public class UserFocusServiceImpl extends BaseServiceImpl<Userfocus> implements UserFocusService {

}
