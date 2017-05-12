package org.yoqu.springboot.study.spring.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yoqu.springboot.study.spring.application.repository.entity.User;

import java.util.List;

/**
 * @author yoqu
 * @date 2017年05月12日
 * @time 下午3:18
 * @email wcjiang2@iflytek.com
 */
public interface UserRepository extends CustomRepository<User,Long> {

    List<User> findByAge(Integer age);

}
