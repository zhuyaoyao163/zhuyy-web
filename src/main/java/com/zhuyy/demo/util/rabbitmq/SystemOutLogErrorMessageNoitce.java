package com.zhuyy.demo.util.rabbitmq;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
@Component
public class SystemOutLogErrorMessageNoitce implements ChannelAwareMessageListener {

	 private static final Logger logger = Logger.getLogger(SystemOutLogErrorMessageNoitce.class);
	    @Autowired
	    private MessageConverter msgConverter;
	    /** logger b */
	    @Autowired
	    private JavaMailSenderImpl senderImpl;
	    
	    @Override
	    public void onMessage(Message message, Channel channel) throws Exception {

	        Object obj = null;
	        try {
	            obj = msgConverter.fromMessage(message);
	            logger.info("收到消息："+obj.toString());
	        } catch (MessageConversionException e) {
	            logger.error("convert MQ message error.", e);
	        } finally {
	            long deliveryTag = message.getMessageProperties().getDeliveryTag();
	            logger.info("deliveryTag = " + deliveryTag);
//	            if (deliveryTag != App.DELIVERIED_TAG) {
//	                channel.basicAck(deliveryTag, false);
//	                message.getMessageProperties().setDeliveryTag(App.DELIVERIED_TAG);
//	                logger.info("revice and ack msg: " + (obj == null ? message : new String((byte[]) obj)));
//	            }
	        }
	        if (obj == null) {
	            return;
	        }
	        JSONObject map = JSONObject.parseObject((String) obj);
	        sendMailSystemLoggerError(map.getString("date"), map.getString("subject"), map.getString("domain"), map.getString("requestURL"), map.getString("message"));
	    }
	    
	    /**
	     * jmail logger 
	    * @author 小高
	    * @date 2016年10月25日 下午3:24:46
	    * @param date          日期
	    * @param subject       主题账户
	    * @param domain        域名环境
	    * @param message       logger日志
	    * @param requestURL    请求路径
	    * @throws Exception    异常信息
	     */
	    public void sendMailSystemLoggerError(String date, String subject, String domain, String requestURL, String message) throws Exception{
	        MimeMessage mailMessage = this.senderImpl.createMimeMessage();
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
	        messageHelper.setTo("784822936@qq.com");
	        messageHelper.setFrom("zhu_yaoyao@163.com");
	        messageHelper.setSubject(date + " 系统异常");
	        String msg = "<p>异常时间：" + date + "</p><p>门店企业：" + subject + "</p>"
	                    + "<p>部署环境：" + domain + "</p><p>异常连接：" + requestURL + "</p>"
	                    + "<p>异常内容：</p>" + message;
	        messageHelper.setText("<html><head></head><body>" + msg + "</body></html>", true);
	        senderImpl.send(mailMessage);
	        logger.info("jmail push message success");
	    }

}
