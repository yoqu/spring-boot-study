package org.yoqu.springboot.study.spring.application.propertyvalue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午8:11
 * @email wcjiang2@iflytek.com
 */
@Component
@ConfigurationProperties(prefix = "author")
public class Author {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
