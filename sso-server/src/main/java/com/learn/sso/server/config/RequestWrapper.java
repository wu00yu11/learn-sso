package com.learn.sso.server.config;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author jingjing.zhang
 */
public class RequestWrapper extends HttpServletRequestWrapper {
    private static final Logger logger = LoggerFactory.getLogger(RequestWrapper.class);
    private final byte[] body;
    private String params;

    public RequestWrapper(HttpServletRequest request) {
        super(request);
        params = getBodyString(request);
        body = params.getBytes(Charset.forName("UTF-8"));
    }

    /**
     * 获取请求Body
     *
     * @param request
     * @return
     */
    public String getBodyString(final ServletRequest request) {
        Map<String,String[]> map =  request.getParameterMap();
        String bodyString ="";
        if (null != map && map.size() != 0) {
            bodyString = JSON.toJSONString(map);
        }else {
            try {
                byte[] byteArray = StreamUtils.copyToByteArray(request.getInputStream());
                bodyString = new String(byteArray, "UTF-8");
            } catch (IOException e) {
                logger.error("RequestWrapper getById request body exception",e);
            }
        }
        return bodyString;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bos = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bos.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }

    public String getParams() {
        return params;
    }
}
