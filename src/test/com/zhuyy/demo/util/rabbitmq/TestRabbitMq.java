package com.zhuyy.demo.util.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml",
        "classpath:spring-mybatis.xml","classpath:spring/applicationContext-cache.xml"})
public class TestRabbitMq {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRabbitMq.class);
    @Resource
    private AmqpTemplate amqpTemplate;

    @Test
    public void testProducer() {
        amqpTemplate.convertAndSend("queueTest", "foo");
        String foo = (String) amqpTemplate.receiveAndConvert("queueTest");
        LOGGER.info("接收内容："+foo);
    }
}
