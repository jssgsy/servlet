package com.univ.servlet.annotation;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author univ date 2023/6/2
 */
@WebServlet(name = "HeaderServlet", urlPatterns = {"/headerServlet"})
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 取Header
        Enumeration<String> headers = req.getHeaderNames();

        // 设置Header
        resp.setHeader("my_header1", "my_header1_value1");
        resp.setHeader("my_header1", "my_header1_value2");
        resp.setHeader("my_header1", "my_header1_value3");

        resp.addHeader("my_header2", "my_header2_value1");
        resp.addHeader("my_header2", "my_header2_value2");
        resp.addHeader("my_header2", "my_header2_value3");
    }
}
