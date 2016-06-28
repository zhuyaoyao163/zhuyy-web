package com.zhuyy.demo.util.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MyHttpSessionListener implements HttpSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("session created"+httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("session destroyed"+httpSessionEvent.getSession().getId());
    }
}
