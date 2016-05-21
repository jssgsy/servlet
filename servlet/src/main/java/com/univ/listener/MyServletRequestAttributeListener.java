package com.univ.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:13:37 
 * @version 1.0 
*/

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("MyServletRequestAttributeListener.attributeAdded(ServletRequestAttributeEvent srae)");
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("MyServletRequestAttributeListener.attributeRemoved(ServletRequestAttributeEvent srae)");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("MyServletRequestAttributeListener.attributeReplaced(ServletRequestAttributeEvent srae)");
	}

}

