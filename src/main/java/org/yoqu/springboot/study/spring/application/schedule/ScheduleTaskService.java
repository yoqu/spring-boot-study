package org.yoqu.springboot.study.spring.application.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午4:50
 * @email wcjiang2@iflytek.com
 */
@Service
public class ScheduleTaskService {
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportTime(){
        System.out.println("当前时间:"+sdf.format(new Date()));
    }

    @Scheduled(cron = "0 57 16 ? * *")
    public void reportTimeExecution(){
        System.out.println("指定时间执行:"+sdf.format(new Date()));
    }
}
