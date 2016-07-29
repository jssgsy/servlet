package com.univ.servlet.ajax;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(AjaxServlet.class);

	//用以接收ajax的get请求方式
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("begin AjaxServlet.doGet()");
		//解决get方式请求参数乱码问题
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8");
		logger.debug("请求参name的值为: " + name);
		response.setContentType("text/html;charset=utf-8");//设置响应内容编码

		PrintWriter out = response.getWriter();
		out.println("这是get方式返回的自服务器的数据");
		out.close();
		logger.debug("end AjaxServlet.doGet()");

	}

	//用以接收ajax的post请求方式
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("begin AjaxServlet.doPost()");
		request.setCharacterEncoding("utf-8");//解决post方式请求参数乱码问题（不适用于get方式）
		String name = request.getParameter("name");
		logger.debug("请求参数name的值为: " + name);
		String age = request.getParameter("age");
		logger.debug("请求参数age的值为: " + age);
		response.setContentType("text/html;charset=utf-8");//设置响应内容编码
		PrintWriter out = response.getWriter();
		out.println("这是post方式返回的自服务器的数据");
		out.close();
		logger.debug("post AjaxServlet.doPost()");

	}

}
