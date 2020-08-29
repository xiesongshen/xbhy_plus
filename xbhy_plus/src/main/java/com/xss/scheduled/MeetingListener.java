package com.xss.scheduled;

import com.xss.service.MeetingService;
import com.xss.utils.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.Timer;


/**
 * @author XSS
 * @date 2020/6/22
 * @desc
 */
@WebListener
public class MeetingListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MeetingService meetingService = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext()).getBean(MeetingService.class);
        Timer timer = new Timer(true);
        //参数一：需要执行的任务，参数三：每隔多长时间执行一次（单位毫秒）
        timer.schedule(new MeetingTask(meetingService), new Date(), 1 * 1000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
