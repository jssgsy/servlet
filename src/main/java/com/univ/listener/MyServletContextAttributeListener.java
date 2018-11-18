package com.univ.listener;

import com.univ.util.ElementShow;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:02:33 
 * @version 1.0 
*/

public class MyServletContextAttributeListener implements ServletContextAttributeListener, ElementShow {

	private Logger logger = Logger.getLogger(MyServletContextAttributeListener.class);

	/*
	 * 实验证明，应用启动的时候会自动往ServletContext中添加几个属性，但这里却只调用了一次。？
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
		if (!show()) {
			return;
		}
		logger.debug("MyServletContextAttributeListener.attributeAdded(ServletContextAttributeEvent event)");
//		Enumeration<String> enums = event.getServletContext().getAttributeNames();
//		System.out.println("这是是应用启动时自动添加的属性----------start---------");
//		while (enums.hasMoreElements()) {
//			String name = (String) enums.nextElement();
//			System.out.println(name + " : " + event.getServletContext().getAttribute(name));
//		}
//		System.out.println("以上是应用启动时自动添加的属性----------end---------");

	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		if (!show()) {
			return;
		}
		logger.debug("MyServletContextAttributeListener.attributeRemoved(ServletContextAttributeEvent event)");
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		if (!show()) {
			return;
		}
		logger.debug("MyServletContextAttributeListener.attributeReplaced(ServletContextAttributeEvent event)");
	}

	@Override
	public boolean show() {
		return false;
	}
}

