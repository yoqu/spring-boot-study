package org.yoqu.springboot.study.spring.application.job;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * @author yoqu
 * @date 2017年05月23日
 * @time 下午4:58
 * @email wcjiang2@iflytek.com
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {
    @Override
    public Person process(Person item) throws ValidationException {

        return super.process(item);
    }
}
