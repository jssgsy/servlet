package com.univ.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:15:02 
 * @version 1.0 
*/

public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("MyHttpSessionListener.sessionCreated(HttpSessionEvent se)");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("MyHttpSessionListener.sessionDestroyed(HttpSessionEvent se)");
	}

}

