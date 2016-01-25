package com.univ.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @author: liuml
 * @date: 2016年1月25日 下午7:27:19 
 * @version: 1.0 
 * @description: 
 * 注意servlet获取初始化参数的方法(与filter对比):
 * 直接调用父类HttpServlet的getServletConfig()取得ServletConfig对象。
 */

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletConfig servletConfig = super.getServletConfig();
		System.out.println("给HelloServlet配置的初始化参数为： " + servletConfig.getInitParameter("name"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//一般都是将请求委托给doGet方法
		doGet(req, resp);
	}
	
}


