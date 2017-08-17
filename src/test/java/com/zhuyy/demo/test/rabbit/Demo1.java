package com.zhuyy.demo.test.rabbit;

import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhuyy.demo.test.base.BaseTest;

public class Demo1 extends BaseTest{

	@Autowired
	private RabbitTemplate amqpTemplate;
	
	@Test
	public void test1(){
		Object msg = "test message";
		amqpTemplate.convertAndSend(msg);
		System.out.println("=======end=========");
	}
}
