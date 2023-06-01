package com.univ.servlet.annotation;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Univ on 16/7/29.
 */

/**
 * 演示cookie传递数据
 *  服务器端cookie是通过响应头Set-Cookie传给客户端的;
 *  客户端cookie是通过请求头Cookie传给服务器的;
 *
 */
@WebServlet(name = "CookieServlet", urlPatterns = {"/cookieServlet"})
public class CookieServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(CookieServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("univ_cookie")) {
                out.write("last time you visited here is : "+ cookies[i].getValue());//直接写给浏览器
                cookies[i].setValue("univ_cookie_value_new");
                response.addCookie(cookies[i]);
            }
        }
        Cookie c = new Cookie("univ_cookie", "univ_cookie_value");
        c.setMaxAge(60*60*24*30);//设置cookie生存期为一个月
        response.addCookie(c);//将cookie发送给浏览器
    }
}
