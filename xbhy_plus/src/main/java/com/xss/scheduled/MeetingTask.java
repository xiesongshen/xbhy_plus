package com.xss.scheduled;

import com.xss.service.MeetingService;
import com.xss.utils.WebApplicationContextUtils;

import java.util.TimerTask;


/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
public class MeetingTask extends TimerTask {

    private boolean isRunning = false;

    private MeetingService meetingService;

    public MeetingTask(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    public MeetingTask() {
        super();
    }

    @Override
    public void run() {
        if (!isRunning) {
            isRunning = true;
            //开始执行
            meetingService.updateStatusTask();
            //执行结束
            isRunning = false;
        }
    }

}
