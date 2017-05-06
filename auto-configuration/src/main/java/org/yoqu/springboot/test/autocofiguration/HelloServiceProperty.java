package org.yoqu.springboot.test.autocofiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yoqu
 * @date 2017年05月06
 * @time 上午10:09
 * @email wcjiang2@iflytek.com
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperty {
    private String msg = "Hello world";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
