package org.yoqu.springboot.study.spring.application.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author yoqu
 * @date 2017年05月12日
 * @time 下午3:17
 * @email wcjiang2@iflytek.com
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
