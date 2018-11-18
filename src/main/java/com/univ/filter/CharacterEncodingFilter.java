package com.univ.filter;

import com.univ.util.ElementShow;
import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Univ on 16/7/29.
 */

/**
 * utf8编码过滤器,用以解决post请求乱码问题
 */
public class CharacterEncodingFilter implements Filter, ElementShow {

    private Logger logger = Logger.getLogger(CharacterEncodingFilter.class);
    private String encoding;
    public void destroy() {
        if (!show()) {
            return;
        }
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (!show()) {
            // 注意，这里必须将请求交给后面的servlet，否则servlet接收不到请求
            chain.doFilter(req, resp);
            return;
        }
        logger.debug("being CharacterEncodingFilter.doFilter()-----------");
        logger.debug("默认的编码为: " + req.getCharacterEncoding());
        if (encoding != null) {
            req.setCharacterEncoding(encoding);
        }
        chain.doFilter(req, resp);
        logger.debug("end CharacterEncodingFilter.doFilter()-----------");

    }

    public void init(FilterConfig config) throws ServletException {
        if (!show()) {
            return;
        }
        logger.debug("being CharacterEncodingFilter.init()-----------");
        encoding = config.getInitParameter("encoding");
        logger.debug("end CharacterEncodingFilter.init()-----------");

    }

    @Override
    public boolean show() {
        return false;
    }
}
