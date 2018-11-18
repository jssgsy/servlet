package com.univ.listener;

import com.univ.util.ElementShow;
import org.apache.log4j.Logger;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/** 
 * @author	Univ 
 * @date	2016年5月4日 下午12:13:37 
 * @version 1.0 
*/

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener, ElementShow {

	private Logger logger = Logger.getLogger(MyServletRequestAttributeListener.class);

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		if (!show()) {
			return;
		}
		logger.debug("MyServletRequestAttributeListener.attributeAdded(ServletRequestAttributeEvent srae)");
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		if (!show()) {
			return;
		}
		logger.debug("MyServletRequestAttributeListener.attributeRemoved(ServletRequestAttributeEvent srae)");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		if (!show()) {
			return;
		}
		logger.debug("MyServletRequestAttributeListener.attributeReplaced(ServletRequestAttributeEvent srae)");
	}

	@Override
	public boolean show() {
		return false;
	}
}

