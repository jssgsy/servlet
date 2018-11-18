package com.univ.listener;

import com.univ.util.ElementShow;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:16:08 
 * @version 1.0 
*/

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener, ElementShow {
	private Logger logger = Logger.getLogger(MyHttpSessionAttributeListener.class);

	public void attributeAdded(HttpSessionBindingEvent event) {
		if (!show()) {
			return;
		}
		logger.debug("MyHttpSessionAttributeListener.attributeAdded(HttpSessionBindingEvent event)");
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		if (!show()) {
			return;
		}
		logger.debug("MyHttpSessionAttributeListener.attributeRemoved(HttpSessionBindingEvent event)");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		if (!show()) {
			return;
		}
		logger.debug("MyHttpSessionAttributeListener.attributeReplaced(HttpSessionBindingEvent event)");
	}

	@Override
	public boolean show() {
		return false;
	}
}

