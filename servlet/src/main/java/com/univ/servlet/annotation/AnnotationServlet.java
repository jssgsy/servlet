package com.univ.servlet.annotation;

import com.univ.servlet.HelloServlet;
import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @author: liuml
 * @date: 2016年1月26日 上午10:02:37 
 * @version: 1.0 
 * @description: servlet的注解测试
 * 1.使用注解的servlet不用在web.xml中进行配置:
 * 2.虽然使用注解，但自定义的servlet还是的继承HttpServlet；
 * 3.只有一个参数，使用value属性，和其他属性搭配使用，使用urlPatterns属性；
 * 4.注意initParams属性的赋值写法；
 */
@WebServlet(urlPatterns={"/annotation"},initParams={
		@WebInitParam(name="name",value="univ")})
public class AnnotationServlet extends HttpServlet{
	private Logger logger = Logger.getLogger(AnnotationServlet.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("使用注解的servlet还是得继承自HttpServlet---");
		logger.debug("给注解的servlet AnnotationServlet配置的初始化参数为： " + getServletConfig().getInitParameter("name"));
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
}


