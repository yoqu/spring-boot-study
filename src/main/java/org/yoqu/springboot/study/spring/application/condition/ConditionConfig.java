package org.yoqu.springboot.study.spring.application.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午5:02
 * @email wcjiang2@iflytek.com
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ConditionConfig {



    @Conditional(WindowCondition.class)
    @Bean
    public OperateService windowsService(){
        return new WindowsService();
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public OperateService LinuxService(){
        return new LinuxService();
    }

    @Conditional(MacCondition.class)
    @Bean
    public OperateService MacService(){
        return new MacService();
    }
}
