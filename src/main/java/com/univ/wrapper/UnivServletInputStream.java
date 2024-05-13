package com.univ.wrapper;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author univ
 * date 2024/5/13
 */
public class UnivServletInputStream extends ServletInputStream {

    // 这里借助作为媒介，比直接使用byte[]更方便
    private final ByteArrayInputStream byteArrayInputStream;

    public UnivServletInputStream(byte[] bytes) {
        this.byteArrayInputStream = new ByteArrayInputStream(bytes);
    }

    /**
     * Returns true when all the data from the stream has been read else it returns false.
     * true when all data for this particular request has been read, otherwise returns false.
     *
     * 此流是否有被读完
     * 因为用的是ByteArrayInputStream，直接调用available方法即可
     */
    public boolean isFinished() {
        return byteArrayInputStream.available() == 0;
    }

    /**
     * Returns true if data can be read without blocking else returns false.
     * 此流是否可以被读
     *
     * 因为用的是ByteArrayInputStream，直接true
     */
    public boolean isReady() {
        return true;
    }

    public void setReadListener(ReadListener readListener) {
        // 这里什么也不用做，或者直接抛出异常
    }

    public int read() throws IOException {
        // 直接使用ByteArrayInputStream的read方法
        return byteArrayInputStream.read();
    }
}
