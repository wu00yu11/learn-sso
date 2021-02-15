package com.learn.sso.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wu00y
 */
@WebFilter(urlPatterns = "/", filterName = "crossDomainFilter")
@Slf4j
public class CrossDomainFilter extends OncePerRequestFilter {

    @Override
    protected void initFilterBean() throws ServletException {
        log.info("CrossDomainFilter execute initFilterBean() method ... ");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","Content-Type");
        httpServletResponse.setHeader("Access-Control-Max-Age","1800");

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
        log.info("CrossDomainFilter execute destroy() method ... ");
    }
}
