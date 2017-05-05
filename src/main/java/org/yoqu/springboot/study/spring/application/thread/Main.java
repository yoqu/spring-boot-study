package org.yoqu.springboot.study.spring.application.thread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午3:24
 * @email wcjiang2@iflytek.com
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService service = configApplicationContext.getBean(AsyncTaskService.class);
        for (int i = 0; i < 20; i++) {
            service.executeAsyncTask(i);
            service.AsyncTaskPlus(i);
            System.out.println("循环第" + i + "次");
        }
        configApplicationContext.close();
    }
}
