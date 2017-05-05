package org.yoqu.springboot.study.spring.application.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午3:23
 * @email wcjiang2@iflytek.com
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i ){
        System.out.println("执行异步任务"+i);
    }

    @Async
    public void AsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1 :"+(i+1));
    }
}
