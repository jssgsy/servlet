package com.univ.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author Univ
 * @date 2016年5月4日 下午12:17:41
 * @version 1.0
 */

public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
	private Logger logger = Logger.getLogger(MyHttpSessionBindingListener.class);

	public void valueBound(HttpSessionBindingEvent event) {
		logger.debug("MyHttpSessionBindingListener.valueBound(HttpSessionBindingEvent event) ");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		logger.debug("MyHttpSessionBindingListener.valueUnbound(HttpSessionBindingEvent event) ");
	}

}
