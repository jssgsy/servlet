package com.univ.servlet.annotation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/** 
 * @author: liuml
 * @date: 2016年1月26日 上午10:56:12 
 * @version: 1.0 
 * @description: filter的注解测试
 * 1.和AnnotationServlet对照着看，很简单；
 * 2.使用注解定义的filter的初始化比在普通的filter早；
 */

@WebFilter(urlPatterns={"/annotation"},initParams={@WebInitParam(name="name",value="univ")})
public class AnnotationFilter implements Filter {

	private FilterConfig filterConfig;
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AnnotationFilter初始化");
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("给注解的filter AnnotationFilter配置的初始化参数为： " + filterConfig.getInitParameter("name"));
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}


