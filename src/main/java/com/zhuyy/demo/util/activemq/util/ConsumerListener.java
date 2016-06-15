package com.zhuyy.demo.util.activemq.util;

/**
 * Created by Administrator on 2016/6/15.
 */
public class ConsumerListener {
    public void handleMessage(String message) {
        System.out.println("ConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
    }

    public void receiveMessage(String message) {
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
    }
}
