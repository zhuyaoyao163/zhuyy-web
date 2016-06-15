package com.zhuyy.demo.util.activemq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Administrator on 2016/6/14.
 */
public class QueueMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(QueueMessageListener.class);
    private ObjectMessageConverter messageConverter;

    /**
     * 接收消息
     */
    @Override
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        try {
            Object noticeInfo = messageConverter.fromMessage(message);
            logger.info("queue收到消息" + noticeInfo.toString());
            logger.info("model:" + message.getJMSDeliveryMode());
            logger.info("destination:" + message.getJMSDestination());
            logger.info("type:" + message.getJMSType());
            logger.info("messageId:" + message.getJMSMessageID());
            logger.info("time:" + message.getJMSTimestamp());
            logger.info("expiredTime:" + message.getJMSExpiration());
            logger.info("priority:" + message.getJMSPriority());

        } catch (Exception e) {
            // TODO: handle exception
            logger.error("处理信息时发生异常", e);
        }
    }

    public ObjectMessageConverter getMessageConverter() {
        return messageConverter;
    }

    public void setMessageConverter(ObjectMessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }
}
