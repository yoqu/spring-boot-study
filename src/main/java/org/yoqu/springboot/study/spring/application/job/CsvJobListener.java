package org.yoqu.springboot.study.spring.application.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author yoqu
 * @date 2017年05月23日
 * @time 下午5:07
 * @email wcjiang2@iflytek.com
 */
public class CsvJobListener implements JobExecutionListener {
    long startTime;
    long endTime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime=System.currentTimeMillis();
        System.out.println("任务开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
endTime=System.currentTimeMillis();
        System.out.println("任务结束");
        System.out.println("耗时："+(endTime-startTime)/1000+" s");
    }
}
