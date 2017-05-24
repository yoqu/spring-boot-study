package org.yoqu.springboot.study.spring.application.job;

import javax.validation.constraints.Size;

/**
 * @author yoqu
 * @date 2017年05月23日
 * @time 下午5:04
 * @email wcjiang2@iflytek.com
 */
public class Person {

    @Size(max = 4,min = 2)
    private String name;


    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
