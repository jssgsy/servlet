package com.univ.wrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author univ
 * date 2024/5/13
 */
@WebFilter(urlPatterns = "/*", filterName = "UnivHttpServletRequestWrapperFilter")
public class RequestWrapperDemoFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("===UnivHttpServletRequestWrapperFilter===");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        ServletInputStream inputStream = httpServletRequest.getInputStream();
        // read from inputSteam
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffRead = new byte[1024];
        int readByteLen = inputStream.read(buffRead);
        while (-1 != readByteLen) {
            byteArrayOutputStream.write(buffRead, 0, readByteLen);
            readByteLen = inputStream.read(buffRead);
        }
        byte[] bodyData = byteArrayOutputStream.toByteArray();
        System.out.println("请求体的实际大小为：" + bodyData.length);
        System.out.println("请求体的内容为：" + new String(bodyData));
        if (bodyData.length > 1000) {
            throw new RuntimeException("请求体数据过大");
        }
        UnivHttpServletRequestWrapper requestWrapper = new UnivHttpServletRequestWrapper(httpServletRequest, bodyData);
        // 此时后续所有Filter、Servlet获取到的均是UnivHttpServletRequestWrapper实例
        chain.doFilter(requestWrapper, response);
    }

    public void destroy() {

    }
}
