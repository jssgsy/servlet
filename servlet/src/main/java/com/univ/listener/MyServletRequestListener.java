package com.univ.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:12:11 
 * @version 1.0 
*/

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("MyServletRequestListener.requestDestroyed(ServletRequestEvent sre)");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("MyServletRequestListener.requestInitialized(ServletRequestEvent sre)");
	}

}

