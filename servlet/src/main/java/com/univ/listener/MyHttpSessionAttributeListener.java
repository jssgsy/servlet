package com.univ.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:16:08 
 * @version 1.0 
*/

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionAttributeListener.attributeAdded(HttpSessionBindingEvent event)");
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionAttributeListener.attributeRemoved(HttpSessionBindingEvent event)");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionAttributeListener.attributeReplaced(HttpSessionBindingEvent event)");
	}

}

