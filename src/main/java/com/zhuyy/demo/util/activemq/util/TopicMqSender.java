package com.zhuyy.demo.util.activemq.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

/**
 * Created by Administrator on 2016/6/14.
 */
public class TopicMqSender{

    private static final Logger logger = LoggerFactory.getLogger(TopicMqSender.class);

    private JmsTemplate jmsTemplate;//消息模板

    private Destination destination;//发送消息目的地

    public Destination getDestination() {
        return destination;
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     *
     * @Title: send
     * @Description:
     * @author zhuyy
     * @param obj
     * @throws
     */
    public void send(Object obj) {
        logger.info("---------------生产者发送消息-----------------");
        logger.info("---------------生产者发了一个消息：" + JSON.toJSONString(obj));
//        jmsTemplate.send(destination, new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//            	return session.createTextMessage(message);
//            }
//        });
        jmsTemplate.convertAndSend(destination, obj);
        logger.info("---------------成功发送了一条JMS消息-----------------");
    }
}
