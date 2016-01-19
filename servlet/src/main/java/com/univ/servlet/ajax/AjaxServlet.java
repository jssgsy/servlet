package com.univ.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	//用以接收ajax的get请求方式
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决get方式请求参数乱码问题
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8");
		System.out.println(name);
		response.setContentType("text/html;charset=utf-8");//设置响应内容编码
		PrintWriter out = response.getWriter();
		out.println("这是get方式返回的自服务器的数据");
		out.close();
		
	}

	//用以接收ajax的post请求方式
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//解决post方式请求参数乱码问题（不适用于get方式）
		String name = request.getParameter("name");
		System.out.println(name);
		String age = request.getParameter("age");
		System.out.println(age);
		response.setContentType("text/html;charset=utf-8");//设置响应内容编码
		PrintWriter out = response.getWriter();
		out.println("这是post方式返回的自服务器的数据");
		out.close();
	}

}
