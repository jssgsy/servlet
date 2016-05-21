package com.univ.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:00:47 
 * @version 1.0 
*/

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextInitialized(ServletContextEvent sce)");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextDestroyed(ServletContextEvent sce)");
	}

}

