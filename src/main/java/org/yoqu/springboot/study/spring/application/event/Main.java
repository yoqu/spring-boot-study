package org.yoqu.springboot.study.spring.application.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午2:32
 * @email wcjiang2@iflytek.com
 */
@Configuration
@ComponentScan("org.yoqu.springboot.study.spring.application.event")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(Main.class);

        DemoPublisher publisher = configApplicationContext.getBean(DemoPublisher.class);

        publisher.publish("Hello");

        configApplicationContext.close();

    }
}
