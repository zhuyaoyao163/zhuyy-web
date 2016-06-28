package com.zhuyy.demo.util.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHttpSessionBindingListener.class);

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.info("valueBound:" + httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.info("valueUnbound:" + httpSessionBindingEvent.getSession().getId());
    }
}
