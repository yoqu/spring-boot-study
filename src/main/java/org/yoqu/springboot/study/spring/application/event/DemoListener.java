package org.yoqu.springboot.study.spring.application.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午2:30
 * @email wcjiang2@iflytek.com
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {

        System.out.println("接收到demoDevent的消息:"+demoEvent.getMsg());
    }
}
