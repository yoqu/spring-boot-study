package org.yoqu.springboot.test.autocofiguration;

/**
 * @author yoqu
 * @date 2017年05月06
 * @time 上午10:10
 * @email wcjiang2@iflytek.com
 */
public class HelloService {

    private String msg;

    public void say() {
        System.out.println(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
