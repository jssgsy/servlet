package com.univ.servlet.annotation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                System.out.println("cookie: " + cookie.getName() + "=" + cookie.getValue());
                if (cookie.getName().equals("name")) {
                    cookie.setValue("univ_new");
                    // 因为此Cookie已经存在了，所以这里是覆盖掉之前此Cookie的值，当然，这里仍然是以Set-Cookie响应头的方式来覆盖
                    response.addCookie(cookie);
                }
            }
        } else {
            Cookie c1 = new Cookie("name", "univ");
            Cookie c2 = new Cookie("age", "27");
            Cookie c3 = new Cookie("address", "hubei");

            response.addCookie(c1); // 将Cookie发送给浏览器，以Set-Cookie响应头的方式
            response.addCookie(c2); // 可以有多个，每调用一次就是设置一个Set-Cookie响应头
            response.addCookie(c3);
        }

    }
}
