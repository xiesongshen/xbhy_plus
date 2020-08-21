package com.xss.service.impl;

import com.xss.entity.Dept;
import com.xss.entity.Meeting;
import com.xss.entity.MeetingJoin;
import com.xss.mapper.DeptMapper;
import com.xss.service.DeptService;
import com.xss.service.MeetingJoinService;
import com.xss.service.MeetingService;
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
public class MeetingJoinServiceImpl extends BaseServiceImpl<MeetingJoin> implements MeetingJoinService {

}
