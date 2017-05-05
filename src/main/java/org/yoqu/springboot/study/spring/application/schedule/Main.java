package org.yoqu.springboot.study.spring.application.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午4:53
 * @email wcjiang2@iflytek.com
 */

@Configuration
@EnableScheduling
@ComponentScan("org.yoqu.springboot.study.spring.application.schedule")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Main.class);
    }
}
