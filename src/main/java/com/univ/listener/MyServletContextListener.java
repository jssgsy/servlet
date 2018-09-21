package com.univ.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:00:47 
 * @version 1.0 
*/

public class MyServletContextListener implements ServletContextListener {

	private Logger logger = Logger.getLogger(MyServletContextListener.class);


	public void contextInitialized(ServletContextEvent sce) {
		// 通过ServletContextEvent可以获取到ServletContext对象，进行获取到web.xml中<context-param>的配置值
		ServletContext servletContext = sce.getServletContext();
		String contextParam = servletContext.getInitParameter("name");
		logger.debug("MyServletContextListener：<context-param>的值为：" + contextParam);
		logger.debug("MyServletContextListener.contextInitialized(ServletContextEvent sce)");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("MyServletContextListener.contextDestroyed(ServletContextEvent sce)");
	}

}

