package org.yoqu.springboot.study.spring.application.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午2:28
 * @email wcjiang2@iflytek.com
 */
public class DemoEvent extends ApplicationEvent {
    private String msg ;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }
}
