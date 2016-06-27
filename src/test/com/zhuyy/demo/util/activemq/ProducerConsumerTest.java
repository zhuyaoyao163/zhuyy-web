package com.zhuyy.demo.util.activemq;

import com.zhuyy.demo.util.activemq.util.DemoMqReceiver;
import com.zhuyy.demo.util.activemq.util.TopicMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml",
        "classpath:spring-mybatis.xml","classpath:spring/applicationContext-cache.xml"})
public class ProducerConsumerTest {

//    @Resource
//    private TopicMqSender topicMqSender;
//
//    @Resource
//    private DemoMqReceiver demoMqReceiver;
//
//    @Test
//    public void testMessageListenerAdapter() {
//        topicMqSender.send("测试topic消息");
//    }
//
//    @Test
//    public void testTopicConsumer() {
//        demoMqReceiver.receiveMsg();
//    }
}
