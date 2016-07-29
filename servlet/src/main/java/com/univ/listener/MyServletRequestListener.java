package com.univ.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:12:11 
 * @version 1.0 
*/

public class MyServletRequestListener implements ServletRequestListener {

	private Logger logger = Logger.getLogger(MyServletRequestAttributeListener.class);

	public void requestDestroyed(ServletRequestEvent sre) {
		logger.debug("MyServletRequestListener.requestDestroyed(ServletRequestEvent sre)");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		logger.debug("MyServletRequestListener.requestInitialized(ServletRequestEvent sre)");
	}

}

