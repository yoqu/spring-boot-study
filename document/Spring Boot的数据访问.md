# Spring Boot的数据访问

`author` : [yoqu](http://www.yoqu.org)

`createTime` : 2017年05月11 下午4:03


---

## 5.自定义Repository的实现

示例代码在`org.yoqu.springboot.study.spring.application.repository`包下,
1. 创建一个自定义Repository 的接口,并申明方法.如:
```Java
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
```
2. 创建实现类并写实现代码,例子中针对user的name做一个全等匹配,并不具有通用性,仅为了简单容易理解

```java
package org.yoqu.springboot.study.spring.application.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
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
    申明一个specification,并构造好查询条件
        Specification<T> specification = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //此处针对实体的name进行全等匹配,这意味着继承该Repository需要拥有name属性
                Predicate predicate = criteriaBuilder.equal(root.get("name"),name);
                return criteriaBuilder.and(predicate);
            }
        };
        return findAll(specification);
    }
}
```

3. 创建CustomRepositoryFactoryBean类继承`JpaRepositoryFactoryBean` 并重写`createRepositoryFactory`方法
```Java
package org.yoqu.springboot.study.spring.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author yoqu
 * @date 2017年05月12日
 * @time 下午3:04
 * @email wcjiang2@iflytek.com
 */
public class CustomRepositoryFactoryBean<T extends JpaRepository<S,ID>,S,ID extends Serializable> extends JpaRepositoryFactoryBean<T,S,ID>{


    public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomRepositoryFactory(entityManager);
    }

    private static class CustomRepositoryFactory extends JpaRepositoryFactory{

        public CustomRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
            return new CustomRepositoryImpl<T,ID>((Class<T>)information.getDomainType(),entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomRepositoryImpl.class;
        }
    }
}
```
4. 创建UserRepository的接口并继承CustomRepository.

5. 在配置类中添加`EnableJpaRepositories`注解,并传入我们的`CustomRepositoryFactoryBean`类名到参数中

```Java
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
```

6. 调用autoName的方法生效即为成功声明了一个CustomRepository.