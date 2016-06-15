package com.zhuyy.demo.util.activemq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.Message;

/**
 * Created by Administrator on 2016/6/14.
 */
public class DemoMqReceiver {
    private static final Logger logger = LoggerFactory.getLogger(QueueMessageListener.class);

    private JmsTemplate jmsTemplate;

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

    public void receiveMsg() {
//        Message message1 = jmsTemplate.receive();
//        logger.info(message1.toString());
//        Message message2 = jmsTemplate.receive(destination);
//        logger.info(message2.toString());
//        Object message3 = jmsTemplate.receiveAndConvert();
//        logger.info(message3.toString());
        Object message4 = jmsTemplate.receiveAndConvert(destination);
        logger.info(message4.toString());
    }
}
