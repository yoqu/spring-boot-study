package org.yoqu.springboot.study.spring.application.propertyvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午8:10
 * @email wcjiang2@iflytek.com
 */
@SpringBootApplication
@RestController
public class PropertyApplication {


    @Autowired
    private Author author;

    @RequestMapping("/index")
    public String index(){
        return "name :"+author.getName()+"----Id:"+author.getId();
    }

    public static void main(String[] args) {
        SpringApplication.run(PropertyApplication.class,args);
    }
}
