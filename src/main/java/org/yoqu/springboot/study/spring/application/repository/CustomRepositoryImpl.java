package org.yoqu.springboot.study.spring.application.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * @author yoqu
 * @date 2017年05月11日
 * @time 下午4:25
 * @email wcjiang2@iflytek.com
 */
public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID>implements CustomRepository<T,ID> {
    
    private final EntityManager entityManager;
    
    public CustomRepositoryImpl( Class<T> domainClass, EntityManager entityManager) {
        super(domainClass,entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public List<T> autoName(String name) {
        Specification<T> specification = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("name"),name);
                return criteriaBuilder.and(predicate);
            }
        };
        return findAll(specification);
    }
}
