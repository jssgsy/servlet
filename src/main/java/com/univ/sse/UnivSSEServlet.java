package com.univ.sse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet 3.0开始支持SSE
 * @author univ
 * date 2024/11/18
 */
@WebServlet(name = "univSSEServlet", urlPatterns = {"/sse"})
public class UnivSSEServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 启用SSE，表明这里要当作SSE请求处理而不是http
        resp.setContentType("text/event-stream");
        // 经验证，如不是utf-8，则前端EventSource没法正常建立连接
        resp.setCharacterEncoding("utf-8");
        // 浏览器默认不允许跨域发送SSE请求
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter writer = resp.getWriter();
        for (int i = 1; i < 100; i++) {
            // 要符合sse数据的格式要求，否则客户端可能没法解析
            writer.println("data: line: "  + i + "\n");
            // 别忘了
            writer.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
