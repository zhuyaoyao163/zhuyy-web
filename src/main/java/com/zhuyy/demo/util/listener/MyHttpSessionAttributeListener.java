package com.zhuyy.demo.util.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHttpSessionAttributeListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.info("attributeAdded:" + httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.info("attributeRemoved:" + httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.info("attributeReplaced:" + httpSessionBindingEvent.getSession().getId());
    }
}
