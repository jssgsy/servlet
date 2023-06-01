package com.univ.servlet.annotation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 演示Session用法
 * @author univ date 2023/6/1
 */
@WebServlet(name = "sessionServlet", urlPatterns = {"/sessionServlet"})
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 这一个方法，背后做了非常多的事，生成session，添加响应头Set-Cookie等；
        HttpSession session = req.getSession();
        // 择时使之失效
//        session.invalidate();
        System.out.println("session.isNew() : " + session.isNew());
        System.out.println("session.getCreationTime() : " + session.getCreationTime());
        System.out.println("session.getMaxInactiveInterval() : " + session.getMaxInactiveInterval());
    }
}
