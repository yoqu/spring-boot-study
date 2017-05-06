package org.yoqu.springboot.test.autocofiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yoqu
 * @date 2017年05月06
 * @time 上午10:12
 * @email wcjiang2@iflytek.com
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperty.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello",value = "enable",matchIfMissing = true)
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloServiceProperty helloServiceProperty;

    @Bean
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setMsg(helloServiceProperty.getMsg());
        return service;
    }

}
