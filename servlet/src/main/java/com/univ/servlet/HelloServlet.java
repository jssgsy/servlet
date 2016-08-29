package com.univ.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/** 
 * @author: liuml
 * @date: 2016年1月25日 下午7:27:19 
 * @version: 1.0 
 * @description: 
 * 注意servlet获取初始化参数的方法(与filter对比):
 * 直接调用父类HttpServlet的getServletConfig()取得ServletConfig对象。
 */

public class HelloServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(HelloServlet.class);

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("begin  HelloServlet.doGet()---------------");
		ServletConfig servletConfig = super.getServletConfig();
        logger.debug("给HelloServlet配置的初始化参数为： " + servletConfig.getInitParameter("name"));
        logger.debug("下拉框选中的值为: " + req.getParameter("name"));

        /**
         * 获取多选下拉框的值的方法:String[] strArr = req.getParameterValues(...),
         * 注意不是req.getParameter(...)方法
         */
        String[] multiSelections = req.getParameterValues("multiSelection");
        logger.debug("获取多选下拉框选中的方法为req.getParameterValues(): " + Arrays.toString(multiSelections));

		logger.debug("end  HelloServlet.doGet()---------------");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//一般都是将请求委托给doGet方法
		doGet(req, resp);
	}
	
}


