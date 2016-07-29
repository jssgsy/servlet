package com.univ.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:15:02 
 * @version 1.0 
*/

public class MyHttpSessionListener implements HttpSessionListener {
	private Logger logger = Logger.getLogger(MyHttpSessionListener.class);

	public void sessionCreated(HttpSessionEvent se) {
		logger.debug("MyHttpSessionListener.sessionCreated(HttpSessionEvent se)");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("MyHttpSessionListener.sessionDestroyed(HttpSessionEvent se)");
	}

}

