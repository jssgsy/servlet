package com.univ.listener;

import org.apache.log4j.Logger;

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
		logger.debug("MyServletContextListener.contextInitialized(ServletContextEvent sce)");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("MyServletContextListener.contextDestroyed(ServletContextEvent sce)");
	}

}

