package com.univ.filter;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @author: liuml
 * @date: 2016年1月25日 下午6:58:18 
 * @version: 1.0 
 * @description: 测试filter基本功能
 * filter和servlet对比：
 * 相同点：
 * 		配置文件里的写法类似；(配置初始化参数形式也一致)；
 * 不同点：
 * 		读取初始化参数的方法不同；(servlet直接调用父类的getServletConfig()即可)；
 * 
 * servlet有一个ServletConfig,filter有一个FilterConfig;
 * 
 * 注意filter生命周期中销毁的时机：容器销毁filter实例前，如reloading时(关闭web容器时似乎不被调用)。
 */

public class HelloFilter implements Filter {

	private Logger logger = Logger.getLogger(HelloFilter.class);

	/**
	 * 定义一个成员变量用以接收配置的参数
	 */
	private FilterConfig filterConfig;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("HelloFilter.init()------------");
		this.filterConfig = filterConfig;
	}

	/**
	 * 这里的参数不是HttpServletRequest和HttpServletResponse
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.debug("给HelloFilter配置的初始化参数为： " + filterConfig.getInitParameter("name"));
		logger.debug("before HelloFilter#chain.doFilter()--------------");
		chain.doFilter(request, response);//此时将转到后续的filter(servlet)处执行
		logger.debug("after HelloFilter#chain.doFilter()--------------");

	}

	public void destroy() {
		logger.debug("HelloFilter.destroy() ------------");
	}

}


