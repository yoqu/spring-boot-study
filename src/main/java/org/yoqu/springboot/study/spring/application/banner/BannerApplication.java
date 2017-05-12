package org.yoqu.springboot.study.spring.application.banner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yoqu.springboot.study.spring.application.autoconfiguration.AutoConfigurationApplication;

/**
 * @author yoqu
 * @date 2017年05月11日
 * @time 下午3:50
 * @email wcjiang2@iflytek.com
 */
@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BannerApplication.class,args);
    }
}
