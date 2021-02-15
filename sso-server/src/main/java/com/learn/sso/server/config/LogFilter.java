package com.learn.sso.server.config;

import com.alibaba.fastjson.JSON;
import com.learn.sso.common.utils.IpUtils;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jingjing.zhang
 */
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);


    private static final String ignoreUrlRegex = ".*((/index)|(/index/.*)|([.]((html)|(jsp)|(css)|(js)|(gif)|(png))))$";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);

        // 请求html页面、js不打印日志
        if (httpServletRequest.getRequestURI().matches(ignoreUrlRegex)) {
            ThreadContext.clearAll();
            filterChain.doFilter(servletRequest, responseWrapper);
            return;
        }
        long t1 = System.currentTimeMillis();
        // 记录请求基本信息
        log.info("[Api Access] start.  uri: {}, method: {}, client: {}",
                httpServletRequest.getRequestURI(), httpServletRequest.getMethod(), IpUtils.getIP(httpServletRequest));
        String requestParams = requestWrapper.getParams();
        log.info("[Api Access] request params:{}", JSON.toJSONString(requestParams,false));
        filterChain.doFilter(requestWrapper, responseWrapper);
        // 记录出参
        String outParam = new String(responseWrapper.toByteArray(), responseWrapper.getCharacterEncoding());
        log.info("[Api Access]  response params: {}", JSON.toJSON(outParam));
        log.info("[Api Access]   end. uri: {}, method: {}, client: {}, duration: {}ms",
                httpServletRequest.getRequestURI(), httpServletRequest.getMethod(), IpUtils.getIP(httpServletRequest),System.currentTimeMillis() - t1);
        ThreadContext.clearAll();
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
