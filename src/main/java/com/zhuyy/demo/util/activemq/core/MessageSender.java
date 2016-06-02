package com.zhuyy.demo.util.activemq.core;

import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.alibaba.fastjson.JSON;

/**
 * 
* @ClassName: MessageSender
* @Description: 消息生产者，消息发送者
* @author liweijie
* @date 2015年8月24日 下午3:48:08
*
 */
public class MessageSender {
	Logger logger = LoggerFactory.getLogger(MessageSender.class);
	
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
	* @Description: TODO(发送消息)
	* @author liweijie
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