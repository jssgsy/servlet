package com.univ.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:16:08 
 * @version 1.0 
*/

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
	private Logger logger = Logger.getLogger(MyHttpSessionAttributeListener.class);

	public void attributeAdded(HttpSessionBindingEvent event) {
		logger.debug("MyHttpSessionAttributeListener.attributeAdded(HttpSessionBindingEvent event)");
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("MyHttpSessionAttributeListener.attributeRemoved(HttpSessionBindingEvent event)");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.debug("MyHttpSessionAttributeListener.attributeReplaced(HttpSessionBindingEvent event)");
	}

}

