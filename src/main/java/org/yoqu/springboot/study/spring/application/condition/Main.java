package org.yoqu.springboot.study.spring.application.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午5:02
 * @email wcjiang2@iflytek.com
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        OperateService service = context.getBean(OperateService.class);
        service.say();
    }
}
