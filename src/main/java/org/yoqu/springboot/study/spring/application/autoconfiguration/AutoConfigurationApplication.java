package org.yoqu.springboot.study.spring.application.autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.springboot.test.autocofiguration.HelloService;

/**
 * @author yoqu
 * @date 2017年05月06
 * @time 上午10:21
 * @email wcjiang2@iflytek.com
 */
@SpringBootApplication
@RestController
public class AutoConfigurationApplication {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/index")
    public String index(){
        return helloService.getMsg();
    }
    public static void main(String[] args) {
        SpringApplication.run(AutoConfigurationApplication.class,args);
    }
}
