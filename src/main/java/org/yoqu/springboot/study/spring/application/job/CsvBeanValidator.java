package org.yoqu.springboot.study.spring.application.job;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author yoqu
 * @date 2017年05月23日
 * @time 下午5:05
 * @email wcjiang2@iflytek.com
 */
public class CsvBeanValidator<T> implements Validator<T>,InitializingBean {

    @Override
    public void validate(T t) throws ValidationException {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
