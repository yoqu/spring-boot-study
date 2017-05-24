package org.yoqu.springboot.study.spring.application.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author yoqu
 * @date 2017年05月23日
 * @time 下午5:27
 * @email wcjiang2@iflytek.com
 */
public class Msg implements MessageCreator{

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("消息测试");
    }
}
