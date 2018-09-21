package com.univ.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
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
		// 通过ServletRequestEvent可以获取到ServletContext对象，进行获取到web.xml中<context-param>的配置值
		ServletContext servletContext = sre.getServletContext();
		String contextParam = servletContext.getInitParameter("name");
		logger.debug("MyServletRequestListener：<context-param>的值为：" + contextParam);
		logger.debug("MyServletRequestListener.requestInitialized(ServletRequestEvent sre)");
	}

}

