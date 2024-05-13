package com.univ.wrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author univ
 * date 2024/5/13
 */
@WebServlet("/wrapper/demo")
public class RequestWrapperDemoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
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
    }
}
