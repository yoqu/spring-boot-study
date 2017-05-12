package org.yoqu.springboot.study.spring.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.springboot.study.spring.application.repository.entity.User;

import java.util.List;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午4:53
 * @email wcjiang2@iflytek.com
 */

@RestController
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class Main {

    @Autowired
    private UserRepository userRepository ;

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping("user")
    public List<User> userList(){
        return userRepository.autoName("test");
    }

    @GetMapping("user/add")
    public User addUser(){
        User user = new User();
        user.setAge(10);
        user.setName("abc");
        user = userRepository.save(user);
        return user;
    }
}
