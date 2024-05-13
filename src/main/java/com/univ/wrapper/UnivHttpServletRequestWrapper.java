package com.univ.wrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * @author univ
 * date 2024/5/13
 */
public class UnivHttpServletRequestWrapper extends HttpServletRequestWrapper {

    // 从HttpServletRequest请求体中获取到的数据
    private final byte[] bodyData;

    public UnivHttpServletRequestWrapper(HttpServletRequest request, byte[] bodyData) {
        super(request);
        this.bodyData = bodyData;
    }

    @Override
    public String getParameter(String name) {
        // 场景一：比如在所有请求参数值前加点东西
        return "###" + super.getParameter(name);
    }

    // 当从请求体中获取数据时会被调用
    @Override
    public ServletInputStream getInputStream() throws IOException {
        // 此流会在filter中被消费，因此不能再就读，所以给一个新的
        // ServletInputStream是抽象的，因此必须给一个实现
        return new UnivServletInputStream(bodyData);
    }
}
