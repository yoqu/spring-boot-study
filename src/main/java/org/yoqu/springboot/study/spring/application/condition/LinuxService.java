package org.yoqu.springboot.study.spring.application.condition;

/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午5:01
 * @email wcjiang2@iflytek.com
 */
public class LinuxService implements OperateService {
    @Override
    public void say() {
        System.out.println("ls");
    }
}
