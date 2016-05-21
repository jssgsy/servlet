package com.univ.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author Univ
 * @date 2016年5月4日 下午12:17:41
 * @version 1.0
 */

public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionBindingListener.valueBound(HttpSessionBindingEvent event) ");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("MyHttpSessionBindingListener.valueUnbound(HttpSessionBindingEvent event) ");
	}

}
