package org.yoqu.springboot.study.spring.application.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author yoqu
 * @date 2017年05月11日
 * @time 下午4:05
 * @email wcjiang2@iflytek.com
 */
@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID>{

    List<T> autoName(String  name);
}
