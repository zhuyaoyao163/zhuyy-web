package com.zhuyy.demo.util.activemq.core;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 
* @ClassName: ConsumerMessageListener
* @Description: TODO(消费者监听器)
* @author liweijie
* @date 2015年8月24日 下午5:38:51
*
 */
public class ConsumerMessageListener {
	Logger logger = LoggerFactory.getLogger(ConsumerMessageListener.class);
	
	public void receiveMessage(String message) {
		logger.info(">>ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
    }

    public void receiveMessage(Map map) {
    	logger.info(">>ConsumerListener通过receiveMessage接收到一个map消息，消息内容是：" + JSON.toJSONString(map));
    }
    
    public void receiveMessage(Object obj) {
    	logger.info(">>ConsumerListener通过receiveMessage接收到一个object消息，消息内容是：" + JSON.toJSONString(obj));
    }
    
    public void receiveMessage(byte[] array) {
    	logger.info(">>ConsumerListener通过receiveMessage接收到一个包含byte[]的消息，消息内容是：" + JSON.toJSONString(array));
    }
}